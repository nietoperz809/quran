package numconv;

public class ConvertNumber
{
    /**
     * Converts an array where the ith digit corresponds to (1 / inputBase)^(i + 1)
     * digits[i], return an array output of size outputLength where the ith digit
     * corresponds to (1 / outputBase)^(i + 1) * output[i].
     * <p>
     * Stated in another way, digits is the fractional part of a number
     * expressed in inputBase with the most significant digit first. The output is
     * the same number expressed in outputBase with the most significant digit first.
     * <p>
     * To implement, logically, you're repeatedly multiplying the number by
     * outputBase and chopping off the most significant digit at each iteration:
     * <p>
     * for (i < outputLength) {
     * 1. Keep a carry, initialize to 0.
     * 2. From RIGHT to LEFT
     * a. x = multiply the ith digit by outputBase and add the carry
     * b. the new ith digit is x % inputBase
     * c. carry = x / inputBase
     * 3. output[i] = carry
     * <p>
     * If digits[i] < 0 or digits[i] >= inputBase for any i, return null
     * If inputBase < 2, outputBase < 2, or outputLength < 1, return null
     *
     * @param digits     The input array to translate. This array is not mutated.
     * @param inputBase      The base that the input array is expressed in.
     * @param outputBase      The base to translate into.
     * @param outputLength The number of digits of precision the output should
     *                   have.
     * @return An array of size outputLength expressing digits in outputBase.
     */
    public static int[] convertFraction (int[] digits, int inputBase,
                                         int outputBase, int outputLength)
    {
        long[] opDigits = new long[digits.length];
        for (int t = 0; t < digits.length; t++)
        {
            opDigits[t] = (long) digits[t];
        }

        int[] outputArray = new int[outputLength];

        for (int i = 0; i < outputLength; i++)
        {
            long carry = 0;
            for (int j = digits.length - 1; j >= 0; j--)
            {
                long x = (opDigits[j] * outputBase) + carry;
                opDigits[j] = x % inputBase;
                carry = x / inputBase;
            }
            outputArray[i] = (int) carry;
        }
        return outputArray;
    }

    private static final String dig = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static int[] toDigits (String in)
    {
        int[] res = new int[in.length()];
        for (int s=0; s<in.length(); s++)
        {
            res[s] = dig.indexOf(in.charAt(s));
        }
        return res;
    }

    public static String toString (int[] in)
    {
        StringBuilder sb = new StringBuilder();
        for (int anIn : in)
        {
            sb.append(dig.charAt(anIn));
        }
        return sb.toString();
    }

    public static int[] convertInteger  (int[] digits, int inputBase,
                                         int outputBase /*, int outputLength*/)
    {
        String digs = toString (digits);
        //Integer digi = Integer.parseInt (digs, inputBase);
        String s = Integer.toString(Integer.parseInt(digs, inputBase), outputBase);
        return toDigits(s);
    }

    public static String convNumber (String in, int inBase, int outBase)
    {
        String[] parts = in.split("\\.");
        int[] integer  = toDigits(parts[0]);
        int[] la = convertInteger (integer, inBase, outBase);
        String out = toString(la);
        if (parts.length == 2)
        {
            int[] fraction = toDigits(parts[1]);
            int[] lb = convertFraction (fraction, inBase, outBase, 20);
            out += "." + toString(lb);
        }
        return out;
    }

    public static void main (String[] args)
    {
        String in = "1234.10";
        String o = convNumber(in, 10, 10);
        System.out.println(o);

//        int[] ll = toDigits("123f");
//        String ss = toString(ll);
//        System.out.println(Arrays.toString(ll));
//        System.out.println(ss);
//        int arr[] = {15,0,0,0};
//
//        int res[] = convertFraction(arr, 16, 10, 6);
//        System.out.println(Arrays.toString(res));
    }
}