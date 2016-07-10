/*
   Copyright 2013 AVENTUM SOLUTIONS GmbH (www.aventum-solutions.de)

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package iban;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Implements the @see org.as.iban.Iban interface
 *
 * @author Aventum Solutions GmbH (www.aventum-solutions.de)
 */
public class IbanImpl implements Iban
{

    private static final Pattern BROAD_IBAN_PATTERN = Pattern.compile("^[A-Z]{2}[0-9]{2}[0-9A-Z]{11,30}$");

    //	local variables
    private String country;
    private String checkDigit;
    private BbanImpl bban;

    /**
     * Constructor for validating a given IBAN
     *
     * @param ibanString A iban-code with format "country-code|checkdigit|bank-ident|kto-ident", for example "DE62701500000020228888"
     * @throws IbanException
     */
    public IbanImpl (String ibanString) throws IbanException
    {
        // Start with a general fast check of overall format, avoiding subsequent errors like StringIndexOutOfBoundsException at parsing
        if (ibanString == null || !BROAD_IBAN_PATTERN.matcher(ibanString).find())
        {
            throw new IbanException(IbanException.IBAN_EXCEPTION_INVALID_GENERAL_FORMAT);
        }
        this.setCountry(ibanString);
        this.setCheckDigit(ibanString);
        this.setBban(new BbanImpl(country, ibanString.substring(4, ibanString.length())));
    }

    /**
     * Sets the country of a given IBAN string representation
     *
     * @param ibanString The string representation of the IBAN
     */
    private void setCountry (String ibanString)
    {
        this.country = ibanString.substring(0, 2).toUpperCase(Locale.ENGLISH);
    }

    /**
     * Sets the check digit of a given IBAN string representation
     *
     * @param ibanString The string representation of the IBAN
     */
    private void setCheckDigit (String ibanString)
    {
        this.checkDigit = ibanString.substring(2, 4);
    }

    /**
     * Sets the @see org.as.iban.impl.BbanImpl
     *
     * @param bban The @see org.as.iban.impl.BbanImpl
     */
    private void setBban (BbanImpl bban)
    {
        this.bban = bban;
    }

    /**
     * Constructor generating the IBAN for a specific country with the given bank identifier and account number
     *
     * @param country   The country code
     * @param bankIdent The bank identifier
     * @param ktoIdent  The account number
     * @throws IbanException
     */
    public IbanImpl (String country, String bankIdent, String ktoIdent) throws IbanException
    {
        this.country = country;
        this.bban = new BbanImpl(country, bankIdent, ktoIdent);
        this.checkDigit = calcCheckDigit(bban);
    }

    /**
     * @param bban The BBan (local bank identifier and account number)
     * @throws IbanException
     * @return The check digit for the IBAN
     */
    private String calcCheckDigit (BbanImpl bban) throws IbanException
    {
        String checkDigit = "00";
        String ascii = asciiToNumber(shiftIbanToString(bban, checkDigit));
        checkDigit = String.valueOf(98 - mod97(ascii));
        if (checkDigit.length() == 1)
        {
            checkDigit = "0" + checkDigit;
        }

        return checkDigit;
    }

    /**
     * Convert iban code to a string of numbers (the ascii code numbers)
     *
     * @param shiftedIban The shifted iban code
     * @return The shifted iban code as a string of numbers (the ascii code numbers)
     */
    private String asciiToNumber (String shiftedIban)
    {
        char ch;
        String tmpStr = "";

        shiftedIban.toUpperCase(Locale.ENGLISH);

        for (int i = 0; i <= shiftedIban.length() - 1; i++)
        {
            ch = shiftedIban.charAt(i);

            if ((int) ch >= 48 && (int) ch <= 57)
            {
                tmpStr = tmpStr + ch;
            }

            if ((int) ch >= 65 && (int) ch <= 90)
            {
                tmpStr = tmpStr + ((int) ch - 55);
            }
        }
        return tmpStr;
    }

    /**
     * Generates the shifted iban code (bank-ident|kto-ident|country-code|check-digit)
     *
     * @param bban
     * @return The shifted code
     */
    private String shiftIbanToString (BbanImpl bban, String checkDigit)
    {
        return bban.toString() + country + checkDigit;
    }

    /**
     * Calculates the mod97 of the iban code for the check digit
     *
     * @param modString The given String
     * @return The mod97 of the given String
     */
    private int mod97 (String modString)
    {
        String part = "";
        int modPart;

        for (int i = 0; i < modString.length(); i++)
        {
            if (part.length() < 9)
            {
                part = part + modString.charAt(i);
            }
            else
            {
                modPart = (int) Long.parseLong(part) % 97;
                part = Integer.toString(modPart) + modString.charAt(i);
            }
        }
        return (int) Long.parseLong(part) % 97;
    }

    /* (non-Javadoc)
     * @see org.as.iban.Iban#validate()
     */
    @Override
    public boolean validate () throws IbanException
    {
        validateFormat();
        if (country.equals(CountryCode.COUNTRY_CODE_GERMAN))
        {
            BbanImpl bbanTmp = new BbanImpl(country, bban.getBankIdent(), bban.getKtoIdent());
            String checkDigitTmp = calcCheckDigit(bbanTmp);
            if (this.checkDigit.equals(checkDigitTmp))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            String ascii = asciiToNumber(shiftIbanToString(bban, this.checkDigit));
            if (mod97(ascii) == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /* (non-Javadoc)
     * @see org.as.iban.Iban#getBic()
     */
    @Override
    public String getBic ()
    {
        BankGerman bank = bban.getBankGerman();
        return (bank != null ? bank.getBic() : null);        // cannot determine this for non-german banks
    }

    /**
     * Validates if the current IBAN format is a valid one
     *
     * @throws IbanException
     */
    private void validateFormat () throws IbanException
    {

        IbanFormat ibanFormat = new IbanFormat(country);

        // Validation common IBAN-Format
        if (!this.toString().matches(ibanFormat.getRegexp()))
        {
            throw new IbanException(IbanException.IBAN_EXCEPTION_MESSAGE_FORMAT);
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return this.country + this.checkDigit + this.bban.toString();
    }

}
