import java.util.*;


public class VigenereBreaker 
{
	static String encrypted = "ýivéöfxþspiýötxðgæhekilærlðuipiiaþigpirðlbgmlmrúvpæapaxýaoöttmrblþvötjfjabýtaivxöékójmggsggpxtóvöáoýéérvúóáóðímýuþoúiddrmérbéödrábáyyþrþbehójyuóáírójöiyípæapaxýajvteýæásóihipggátóéyiiúííhgyaxðúlðhéææýíðdúiyæþðæggmyóýuþvéþkúbíðvbídánsíyéarabíbáójðíiíövétdrhárgbtiæivípxúyæýaxsuipignoyæsðvvykrfjísúíkógðtmáíphpíaúyöfðhfdfmúiæéeýæíyaréðaóinðraðaæhúffgtmmbagðþeaúbsyiatyuráxréeoxustvétpíþörðséaxýíovtthbháoréyxithoæfjtaíxóötaiiiííbépaxýrbæáiaxðkbgtaía";
	static Character alphabet[] = {'a', 'á', 'b', 'd', 'ð', 'e', 'é', 'f', 'g', 'h', 'i', 'í', 'j', 'k', 'l', 'm', 'n', 'o', 'ó', 'p', 'r', 's', 't', 'u', 'ú', 'v', 'x', 'y', 'ý', 'þ', 'æ', 'ö'};
	static HashMap<String, Integer> letterToValueMap = new HashMap<String, Integer>();
	static HashMap<Integer, String> letterOrder = new HashMap<Integer, String>();
	
	public static void main(String[] args)
	{ 
		//vignereDecode(encrypted, "íæta"); 
		//vignereDecode(encrypted, "íætp"); 
		//vignereDecode(encrypted, "íæts"); 
		//vignereDecode(encrypted, "íætá"); 
		//vignereDecode(encrypted, "íæti"); 
		//vignereDecode(encrypted, "íætv"); 
		//vignereDecode(encrypted, "íætx"); 
		//vignereDecode(encrypted, "íætb"); 
		//vignereDecode(encrypted, "íætg"); 
		for(int i = 3; i < 13; i++)
		{
			makeGraphForKeyLength(encrypted, i);
		}
	}
    
    /*
    * This method will encode using the Vigenere method, by checking what the shift will be based on the character of the key
    * so if key letter is a then shfit is 0 if its b shift is 1 and so on 
    */
	public static void vignereMap(String plainText, String key)
	{
		char[] cipher = plainText.toCharArray();
		char[] thisKey = key.toCharArray();
		int keyCounter = 0;
		for(int i = 0; i < cipher.length; i++)
		{
			switch(thisKey[keyCounter])
			{
			case 'a':
				break;
			case 'á':
				cipher[i] = replaceSingleChar(cipher[i], 1);
				break;
			case 'b':
				cipher[i] = replaceSingleChar(cipher[i], 2);
				break;
			case 'd':
				cipher[i] = replaceSingleChar(cipher[i], 3);
				break;
			case 'ð':
				cipher[i] = replaceSingleChar(cipher[i], 4);
				break;
			case 'e':
				cipher[i] = replaceSingleChar(cipher[i], 5);
				break;
			case 'é':
				cipher[i] = replaceSingleChar(cipher[i], 6);
				break;
			case 'f':
				cipher[i] = replaceSingleChar(cipher[i], 7);
				break;
			case 'g':
				cipher[i] = replaceSingleChar(cipher[i], 8);
				break;
			case 'h':
				cipher[i] = replaceSingleChar(cipher[i], 9);
				break;
			case 'i':
				cipher[i] = replaceSingleChar(cipher[i], 10);
				break;
			case 'í':
				cipher[i] = replaceSingleChar(cipher[i], 11);
				break;
			case 'j':
				cipher[i] = replaceSingleChar(cipher[i], 12);
				break;
			case 'k':
				cipher[i] = replaceSingleChar(cipher[i], 13);
				break;
			case 'l':
				cipher[i] = replaceSingleChar(cipher[i], 14);
				break;
			case 'm':
                cipher[i] = replaceSingleChar(cipher[i], 15);
				break;
			case 'n':
				cipher[i] = replaceSingleChar(cipher[i], 16);
				break;
			case 'o':
				cipher[i] = replaceSingleChar(cipher[i], 17);
				break;
			case 'ó':
				cipher[i] = replaceSingleChar(cipher[i], 18);
				break;
			case 'p':
				cipher[i] = replaceSingleChar(cipher[i], 19);
				break;
			case 'r':
				cipher[i] = replaceSingleChar(cipher[i], 20);
				break;
			case 's':
				cipher[i] = replaceSingleChar(cipher[i], 21);
				break;
			case 't':
				cipher[i] = replaceSingleChar(cipher[i], 22);
				break;
			case 'u':
				cipher[i] = replaceSingleChar(cipher[i], 23);
				break;
			case 'ú':
				cipher[i] = replaceSingleChar(cipher[i], 24);
				break;
			case 'v':
				cipher[i] = replaceSingleChar(cipher[i], 25);
				break;
            case 'x':
				cipher[i] = replaceSingleChar(cipher[i], 26);
				break;
            case 'y':
				cipher[i] = replaceSingleChar(cipher[i], 27);
				break;
            case 'ý':
				cipher[i] = replaceSingleChar(cipher[i], 28);
				break;
            case 'þ':
				cipher[i] = replaceSingleChar(cipher[i], 29);
				break;
            case 'æ':
				cipher[i] = replaceSingleChar(cipher[i], 30);
				break;
            case 'ö':
				cipher[i] = replaceSingleChar(cipher[i], 31);
				break;
			}
            //this will help us cycle through the key over and over again by resetting once we reach something higher
            //then the key length
			keyCounter++;
			keyCounter = keyCounter % key.length();
		}
		for(int i = 0; i < cipher.length; i++)
		{
			System.out.print(cipher[i]);
		}
	}
    
    //this method will find the index of a character within an array
    public static int findIndexInAlphabet(char c)
    {
        for(int i = 0; i < alphabet.length; i++)
        {
            if(c == alphabet[i])
                return i;
        }
        return -1;
    }
    
    //shifts a character by a certain amount and returns the encrypted or decrypted character
    public static char replaceSingleChar(char c, int val)
    {
        //we add 32 b/c otherwise we will simply end up with negative values, which is bad if we use it as an index, so adding 
        //32 will give us at least 0 if not more (basically we add a 0 but that 0 helps make the index positive)
        return alphabet[(findIndexInAlphabet(c) + val + alphabet.length) % alphabet.length];
    }
    
    
    /*
    * This method simply uses the fact that every key character corresponds to a shift cipher
    * a is shift b shift 1 and so on and so it will cycle through the key over and over again and change every character 
    * back x amount of places in order to find what that character actually is in the plaintext using the replace singleChar
    * method
    */
	public static String vignereDecode(String cipher, String key)
	{
		char[] plainText = cipher.toCharArray();
		char[] thisKey = key.toCharArray();
		int keyCounter = 0;
		for(int i = 0; i < plainText.length; i++)
		{
			switch(thisKey[keyCounter])
			{
			case 'a':
				break;
			case 'á':
				plainText[i] = replaceSingleChar(plainText[i], -1);
				break;
			case 'b':
				plainText[i] = replaceSingleChar(plainText[i], -2);
				break;
			case 'd':
				plainText[i] = replaceSingleChar(plainText[i], -3);
				break;
			case 'ð':
				plainText[i] = replaceSingleChar(plainText[i], -4);
				break;
			case 'e':
				plainText[i] = replaceSingleChar(plainText[i], -5);
				break;
			case 'é':
				plainText[i] = replaceSingleChar(plainText[i], -6); 
				break;
			case 'f':
				plainText[i] = replaceSingleChar(plainText[i], -7);
				break;
			case 'g':
				plainText[i] = replaceSingleChar(plainText[i], -8);
				break;
			case 'h':
				plainText[i] = replaceSingleChar(plainText[i], -9);
				break;
			case 'i':
				plainText[i] = replaceSingleChar(plainText[i], -10);
				break;
			case 'í':
				plainText[i] = replaceSingleChar(plainText[i], -11);
				break;
			case 'j':
				plainText[i] = replaceSingleChar(plainText[i], -12);
				break;
			case 'k':
				plainText[i] = replaceSingleChar(plainText[i], -13);
				break;
			case 'l':
				plainText[i] = replaceSingleChar(plainText[i], -14);
				break;
			case 'm':
				plainText[i] = replaceSingleChar(plainText[i], -15);
				break;
			case 'n':
				plainText[i] = replaceSingleChar(plainText[i], -16);
				break;
			case 'o':
				plainText[i] = replaceSingleChar(plainText[i], -17);
				break;
			case 'ó':
				plainText[i] = replaceSingleChar(plainText[i], -18);
				break;
			case 'p':
				plainText[i] = replaceSingleChar(plainText[i], -19);
				break;
			case 'r':
				plainText[i] = replaceSingleChar(plainText[i], -20);
				break;
			case 's':
				plainText[i] = replaceSingleChar(plainText[i], -21);
				break;
			case 't':
				plainText[i] = replaceSingleChar(plainText[i], -22);
				break;
			case 'u':
				plainText[i] = replaceSingleChar(plainText[i], -23);
				break;
			case 'ú':
				plainText[i] = replaceSingleChar(plainText[i], -24);
				break;
			case 'v':
				plainText[i] = replaceSingleChar(plainText[i], -25);
				break;
            case 'x':
				plainText[i] = replaceSingleChar(plainText[i], -26);
				break;
            case 'y':
				plainText[i] = replaceSingleChar(plainText[i], -27);
				break;
            case 'ý':
				plainText[i] = replaceSingleChar(plainText[i], -28);
				break;
            case 'þ':
				plainText[i] = replaceSingleChar(plainText[i], -29);
				break;
            case 'æ':
				plainText[i] = replaceSingleChar(plainText[i], -30);
				break;
            case 'ö':
				plainText[i] = replaceSingleChar(plainText[i], -31);
				break;        
			}
			keyCounter++;
			keyCounter = keyCounter % key.length();
		}
		String result = "";
		for(int i = 0; i < plainText.length; i++)
		{
			result += plainText[i];
			System.out.print(plainText[i]);
		}
		System.out.println();
		return result;
	}
    
    /*
    * This method will find the amount of times a letter appears in the ith mod k characters in a 
    * cipherText as a 2D array, where each row corrresponds to a graph where row i represents every ith character
    * and for the columns, 0 corresponds to A, 1 to B 2 to C ... up to the length of the alphabet of the cipher
    * so if k was 4, row 0 column 3 would be the amount of appearances of D in the 0 mod 4 subset of characters  
    */
	public static void makeGraphForKeyLength(String cipherText, int k)
	{
		List<Character> splitString = new ArrayList<Character>();
        //2D array to store the appearances of every character
		int occurrences[][] = new int[k][32];
        //separate the cipherText into characters and put them into an arrayList
		for(int i = 0; i < cipherText.length(); i++)
		{
			splitString.add(cipherText.charAt(i));
		}
        
		//System.out.println(splitString);
		
        int row = 0;
        //this loop will compare a character to any of those in the alphabet, and increase the count for that character, but since 
        //we are checking the i mod k character, the row variable is what will keep track of what row or i should it be put on 
		for(int i = 0; i < splitString.size(); i ++)
		{
			switch(splitString.get(i))
			{
			case 'a':
                occurrences[row++][0]++;
				break;
			case 'á':
				occurrences[row++][1]++;
				break;
			case 'b':
				occurrences[row++][2]++;
				break;
			case 'd':
				occurrences[row++][3]++;
				break;
			case 'ð':
				occurrences[row++][4]++;
				break;
			case 'e':
				occurrences[row++][5]++;
				break;
			case 'é':
				occurrences[row++][6]++;
				break;
			case 'f':
				occurrences[row++][7]++;
				break;
			case 'g':
				occurrences[row++][8]++;
				break;
			case 'h':
				occurrences[row++][9]++;
				break;
			case 'i':
				occurrences[row++][10]++;
				break;
			case 'í':
				occurrences[row++][11]++;
				break;
			case 'j':
				occurrences[row++][12]++;
				break;
			case 'k':
				occurrences[row++][13]++;
				break;
			case 'l':
				occurrences[row++][14]++;
				break;
			case 'm':
				occurrences[row++][15]++;
				break;
			case 'n':
				occurrences[row++][16]++;
				break;
			case 'o':
				occurrences[row++][17]++;
				break;
			case 'ó':
				occurrences[row++][18]++;
				break;
			case 'p':
				occurrences[row++][19]++;
				break;
			case 'r':
				occurrences[row++][20]++;
				break;
			case 's':
				occurrences[row++][21]++;
				break;
			case 't':
				occurrences[row++][22]++;
				break;
			case 'u':
				occurrences[row++][23]++;
				break;
			case 'ú':
				occurrences[row++][24]++;
				break;
			case 'v':
				occurrences[row++][25]++;
				break;
            case 'x':
				occurrences[row++][26]++;
				break;
            case 'y':
				occurrences[row++][27]++;
				break;
            case 'ý':
				occurrences[row++][28]++;
				break;
            case 'þ':
				occurrences[row++][29]++;
				break;
            case 'æ':
				occurrences[row++][30]++;
				break;
            case 'ö':
				occurrences[row++][31]++;
				break;
			}
			row = row % k;
		}
        
        //this will print an individual graph for every single mod k subset of our string, graph 0 will 
        //be 0 mod k characters, then graph #1 will be 1 mod k and so on
		for(int j = 0; j < k; j++)
		{
			System.out.println("For key length " + k + " graph #" + j);
			graphETNORIAS(occurrences[j], cipherText);
			/*for(int i = 0; i < 26; i++)
			{
				//System.out.print(Character.toString(97 + i) + " =");
				//System.out.print(" " + occurrences[j][i] + " ");
				for(int n = 0; n < occurrences[j][i]; n++)
				{
					//System.out.print("*");
				}
				//System.out.println();
			}*/
			System.out.println();
		}
	}
    
    /*
    * This method will graph a single graph or set of values in order from most to least appearances in 
    * the cipherText
    */
	public static void graphETNORIAS(int singleGraph[], String cipher)
	{
        //finds the dimensions of our graph
		int height = findMax(singleGraph);
		int max = height;
		int width = alphabet.length;
		int count = 0;
		/*
		 * prints out a graph of the unordered values 
         * this is similar to the actual output but it would print the orders in alphabetical
         * order, which is not good for this question although it was the first way I did and then
         * took this one step further and put the letters in order of appearance
		 *
		for(int j = height; j >= 0; j--)
		{
			if(j >= 10)
				System.out.print(j + "| ");
			else
				System.out.print(j + " | ");
			for(int i = 0; i < width; i++)
			{
				if(singleGraph[i] == j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.print("    ");
		for(int i = 0; i < width; i++)
		{
			System.out.print(Character.toString(97 + i));
		}
		System.out.println();
		 */
        //first we put every single letter as a key into the map, but then also make its value how many times it has appeared
		for(int i = 0; i < width; i++)
		{
			letterToValueMap.put(alphabet[i].toString(), singleGraph[i]);
		}
		
        //this will compare the max amount of our graph with the current key, so check if a is the max
        //if b is the max ... if z is the max, and whatever letter appeared as many times as the max, 
        //will be put into the "next" available value in our map aka put count as the key, very much like a 
        //queue or simulating something like it, which will help us when retrieving the values later
		while(max >= 0)
		{
			for(int i = 0; i < width; i++)
			{
				if(singleGraph[i] == max)
					letterOrder.put(count++, alphabet[i].toString());
			}
			max--;
		}
        
		//System.out.println(letterToValueMap);
		//System.out.println(letterOrder);
		String currentKey = "";
        //this is where the actual graph is plotted in the console, and this is
        //done from top to bottom, starting at the highest value of the graph, and 
        //moving to the layer below
		for(int j = height; j >= 0; j--)
		{
            //first draw the number in our y axis and add a bar next to it
			if(j >= 10)
				System.out.print(j + "| ");
            //if the number is too small it will mess with how our graph looks so add an extra space
			else
				System.out.print(j + " | ");
            //now for all the letters in the graph that appeared the same amount of times as our current height,
            //print * for those that do not, print an empty space
			for(int i = 0; i < width; i++)
			{
                //this allows us to cycle thru the entire alphabet see what letters = the max
				currentKey = letterOrder.get(i);
				if(letterToValueMap.get(currentKey) == j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
        //this is merely for our letters to line up to out * in the graph
		System.out.print("    ");
        //now print the letters in order of most common to least, aka go through our queue and print the values
        //in order
		for(int i = 0; i < width; i++)
		{
			System.out.print(letterOrder.get(i));
		}
		//System.out.println();
		//System.out.println(letterToValueMap);
		//System.out.println(letterOrder);
		
		System.out.println();
	}
    
    //finds the max value for any given array
	public static int findMax(int singleGraph[])
	{
		int max = 0;
		for(int i = 0; i < singleGraph.length; i++)
		{
			if(singleGraph[i] > max)
				max = singleGraph[i];
		}
		return max;
	}
}
