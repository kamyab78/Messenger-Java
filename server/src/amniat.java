public class amniat
{
    protected static String encrypt (String entery)
    {
        String result="";
        char[] array = entery.toCharArray();
        int[] numeric = new int[50];
        int i = 0;
        while (i < array.length) {
            numeric[i] = (((int)array[i]-7+5)%58)+65;
            i++;
        }

        int j = 0;
        while (numeric[j] != 0)
        {
            result+=(char)numeric[j];
            j++;
        }
        return result;
    }

    protected static String decrypt (String entery)
    {
        String result="";
        char[] array = entery.toCharArray();
        int[] numeric = new int[50];
        int i = 0;
        while (i < array.length) {
            numeric[i] = (((int)array[i]-70)%58);
            if(numeric[i]<0)
                numeric[i]+=58;

            numeric[i]+=65;
            i++;
        }
        int j = 0;
        while (numeric[j] != 0)
        {
            result+=(char)numeric[j];
            j++;
        }
        return result;
    }

}

