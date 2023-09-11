import java.util.*;

public class VigenereBreaker 
{
	static String encrypted = "pitbxxtipivzxkrqwmsxyovajpepmzvacqrwsbpxsdixdbizdqepibxbcqezhmcqrsiepziewxwtsisolcktiptvxamfnixqiepjvmxklvhpgfysmzvilzkqavdwfqgpfaespfynmdsxenmdhqdqktittbliwxeblqbrdmmyexcbwuccpivxtpdgsgiehmxqbmeblqwbtolfhlqivfhtsqpquozuxttyzcrptawmzqalqwydbfylwtdoedmqlphmxmzbywvetbepixtkrbleqbsqrpqreusdtxodezrjmmlaaahqxthqcirstpfztdxppviisfdbezipnmrqhlqmrpabdawoxbykidxpp";
	static HashMap<String, Integer> letterToValueMap = new HashMap<String, Integer>();
	static HashMap<Integer, String> letterOrder = new HashMap<Integer, String>();
	public static void main(String[] args)
	{
		//for(int i = 3; i < 13; i++)
		//{
		//	makeGraphForKeyLength(encrypted, i);
		//}
		//makeGraphForKeyLength(encrypted, 6);
		//vignereMap("cycrypt", "fun");
		//vignereDecode(encrypted, "tbfxct");
		//vignereDecode(encrypted, "tbfpts");
		//vignereDecode(encrypted, "tbtits");
		//vignereDecode(encrypted, "pxlisf");
		//vignereDecode(encrypted, "pxlimf");
		
	}

	public static String vignereMap(String plainText, String key)
	{
		char[] cipher = plainText.toCharArray();
		char[] thisKey = key.toCharArray();
		int keyCounter = 0;
		String s = "";
		for(int i = 0; i < cipher.length; i++)
		{
			switch(thisKey[keyCounter])
			{
			case 'a':
				break;
			case 'b':
				cipher[i]++;
				break;
			case 'c':
				cipher[i] += 2;
				break;
			case 'd':
				cipher[i] += 3;
				break;
			case 'e':
				cipher[i] += 4;
				break;
			case 'f':
				cipher[i] += 5;
				break;
			case 'g':
				cipher[i] += 6;
				break;
			case 'h':
				cipher[i] += 7;
				break;
			case 'i':
				cipher[i] += 8;
				break;
			case 'j':
				cipher[i] += 9;;
				break;
			case 'k':
				cipher[i] += 10;
				break;
			case 'l':
				cipher[i] += 11;
				break;
			case 'm':
				cipher[i] += 12;
				break;
			case 'n':
				cipher[i] += 13;
				break;
			case 'o':
				cipher[i] += 14;
				break;
			case 'p':
				cipher[i] += 15;
				break;
			case 'q':
				cipher[i] += 16;
				break;
			case 'r':
				cipher[i] += 17;
				break;
			case 's':
				cipher[i] += 18;
				break;
			case 't':
				cipher[i] += 19;
				break;
			case 'u':
				cipher[i] += 20;
				break;
			case 'v':
				cipher[i] += 21;
				break;
			case 'w':
				cipher[i] += 22;
				break;
			case 'x':
				cipher[i] += 23;
				break;
			case 'y':
				cipher[i] += 24;
				break;
			case 'z':
				cipher[i] += 25;
				break;
			}
			keyCounter++;
			keyCounter = keyCounter % key.length();
			if(cipher[i] > 122)
				cipher[i] -= 26;
		}
		for(int i = 0; i < cipher.length; i++)
		{
			s = s + cipher[i];
			System.out.print(cipher[i]);
		}
		System.out.println();
		return s;
	}

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
			case 'b':
				plainText[i]--;
				break;
			case 'c':
				plainText[i] -= 2;
				break;
			case 'd':
				plainText[i] -= 3;
				break;
			case 'e':
				plainText[i] -= 4;
				break;
			case 'f':
				plainText[i] -= 5;
				break;
			case 'g':
				plainText[i] -= 6;
				break;
			case 'h':
				plainText[i] -= 7;
				break;
			case 'i':
				plainText[i] -= 8;
				break;
			case 'j':
				plainText[i] -= 9;;
				break;
			case 'k':
				plainText[i] -= 10;
				break;
			case 'l':
				plainText[i] -= 11;
				break;
			case 'm':
				plainText[i] -= 12;
				break;
			case 'n':
				plainText[i] -= 13;
				break;
			case 'o':
				plainText[i] -= 14;
				break;
			case 'p':
				plainText[i] -= 15;
				break;
			case 'q':
				plainText[i] -= 16;
				break;
			case 'r':
				plainText[i] -= 17;
				break;
			case 's':
				plainText[i] -= 18;
				break;
			case 't':
				plainText[i] -= 19;
				break;
			case 'u':
				plainText[i] -= 20;
				break;
			case 'v':
				plainText[i] -= 21;
				break;
			case 'w':
				plainText[i] -= 22;
				break;
			case 'x':
				plainText[i] -= 23;
				break;
			case 'y':
				plainText[i] -= 24;
				break;
			case 'z':
				plainText[i] -= 25;
				break;
			}
			keyCounter++;
			keyCounter = keyCounter % key.length();
			if(plainText[i] <= 96)
				plainText[i] += 26;
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

	public static void makeGraphForKeyLength(String cipherText, int k)
	{
		List<Character> splitString = new ArrayList<Character>();
		int occurrences[][] = new int[k][26];
		for(int i = 0; i < cipherText.length(); i++)
		{
			splitString.add(cipherText.charAt(i));
		}
		//System.out.println(splitString);
		int row = 0;
		for(int i = 0; i < splitString.size(); i ++)
		{
			switch(splitString.get(i))
			{
			case 'a':
				occurrences[row++][0]++;
				break;
			case 'b':
				occurrences[row++][1]++;
				break;
			case 'c':
				occurrences[row++][2]++;
				break;
			case 'd':
				occurrences[row++][3]++;
				break;
			case 'e':
				occurrences[row++][4]++;
				break;
			case 'f':
				occurrences[row++][5]++;
				break;
			case 'g':
				occurrences[row++][6]++;
				break;
			case 'h':
				occurrences[row++][7]++;
				break;
			case 'i':
				occurrences[row++][8]++;
				break;
			case 'j':
				occurrences[row++][9]++;
				break;
			case 'k':
				occurrences[row++][10]++;
				break;
			case 'l':
				occurrences[row++][11]++;
				break;
			case 'm':
				occurrences[row++][12]++;
				break;
			case 'n':
				occurrences[row++][13]++;
				break;
			case 'o':
				occurrences[row++][14]++;
				break;
			case 'p':
				occurrences[row++][15]++;
				break;
			case 'q':
				occurrences[row++][16]++;
				break;
			case 'r':
				occurrences[row++][17]++;
				break;
			case 's':
				occurrences[row++][18]++;
				break;
			case 't':
				occurrences[row++][19]++;
				break;
			case 'u':
				occurrences[row++][20]++;
				break;
			case 'v':
				occurrences[row++][21]++;
				break;
			case 'w':
				occurrences[row++][22]++;
				break;
			case 'x':
				occurrences[row++][23]++;
				break;
			case 'y':
				occurrences[row++][24]++;
				break;
			case 'z':
				occurrences[row++][25]++;
				break;
			}
			row = row % k;
		}

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
	public static void graphETNORIAS(int singleGraph[], String cipher)
	{
		int height = findMax(singleGraph);
		int max = height;
		int width = 26;
		int count = 0;
		/*
		 * prints out a graph of the unordered values 
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
		for(int i = 0; i < width; i++)
		{
			letterToValueMap.put(Character.toString(97 + i), singleGraph[i]);
		}
		while(max >= 0)
		{
			for(int i = 0; i < width; i++)
			{
				if(singleGraph[i] == max)
					letterOrder.put(count++, Character.toString(97 + i));
			}
			max--;
		}
		//System.out.println(letterToValueMap);
		//System.out.println(letterOrder);
		String currentKey = "";
		for(int j = height; j >= 0; j--)
		{
			if(j >= 10)
				System.out.print(j + "| ");
			else
				System.out.print(j + " | ");
			for(int i = 0; i < width; i++)
			{
				currentKey = letterOrder.get(i);
				if(letterToValueMap.get(currentKey) == j)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.print("    ");
		for(int i = 0; i < width; i++)
		{
			System.out.print(letterOrder.get(i) );
		}
		System.out.println();
	}

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
