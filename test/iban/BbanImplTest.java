package iban;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 7/9/2016.
 */
public class BbanImplTest
{
    @Test
    public void testIbanImplWichser()
    {
        String bankIdent = "25070070";
        String ktoIdent = "014482400";
        Iban iban;
        try
        {
            iban = new IbanImpl(CountryCode.COUNTRY_CODE_GERMAN.toString(), bankIdent, ktoIdent);
            System.out.println(iban.toString());
            System.out.println(iban.getBic());
            assertEquals("DE40250700700014482400", iban.toString());
        }
        catch (IbanException e)
        {
            fail(e.getMessage());
        }
    }
}