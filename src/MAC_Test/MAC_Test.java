package MAC_Test;

public class MAC_Test
{
	static private String HexInt(int i)
	{
		String s = new String();
		int y = i;
		int x = 0;
		while(y > 0)
		{
			if(x > 1)
			{
				s = " " + s;
				x = 0;
			}
			switch(y%16)
			{
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					s = Integer.toString(y%16) + s;
					break;
				case 10:
					s = 'a' + s;
					break;
				case 11:
					s = 'b' + s;
					break;
				case 12:
					s = 'c' + s;
					break;
				case 13:
					s = 'd' + s;
					break;
				case 14:
					s = 'e' + s;
					break;
				case 15:
					s = 'f' + s;
					break;
			}
			y /= 16;
			x++;
		}
		if(s.length() == 0)
		{
			s = "00 00 00 00";
		}
		while(s.length() < 11)
		{
			if(x > 1)
			{
				s = "0 " + s;
				x = 1;
			}
			else
			{
				s = '0' + s;
				x++;
			}
		}
		return s;
	}
	static private String BinHex(String Hex)
	{
		String s = new String();
		int y = 0;
		for(int i = 0; i < Hex.length(); i += 4)
		{
			String Comp = Hex.substring(i, i+4);
			if(y > 1)
			{
				s = s + ' ';
				y = 0;
			}
			if(Comp.compareTo("0000") == 0)
			{
				s = s + '0';
			}
			else if(Comp.compareTo("0001") == 0)
			{
				s = s + '1';
			}
			else if(Comp.compareTo("0010") == 0)
			{
				s = s + '2';
			}
			else if(Comp.compareTo("0011") == 0)
			{
				s = s + '3';
			}
			else if(Comp.compareTo("0100") == 0)
			{
				s = s + '4';
			}
			else if(Comp.compareTo("0101") == 0)
			{
				s = s + '5';
			}
			else if(Comp.compareTo("0110") == 0)
			{
				s = s + '6';
			}
			else if(Comp.compareTo("0111") == 0)
			{
				s = s + '7';
			}
			else if(Comp.compareTo("1000") == 0)
			{
				s = s + '8';
			}
			else if(Comp.compareTo("1001") == 0)
			{
				s = s + '9';
			}
			else if(Comp.compareTo("1010") == 0)
			{
				s = s + 'A';
			}
			else if(Comp.compareTo("1011") == 0)
			{
				s = s + 'B';
			}
			else if(Comp.compareTo("1100") == 0)
			{
				s = s + 'C';
			}
			else if(Comp.compareTo("1101") == 0)
			{
				s = s + 'D';
			}
			else if(Comp.compareTo("1110") == 0)
			{
				s = s + 'E';
			}
			else if(Comp.compareTo("1111") == 0)
			{
				s = s + 'F';
			}
			y++;
		}
		return s;
	}
	static private String HexBin(String i)
	{
		String y = new String();
		for(int z = 0; z < i.length(); z++)
		{
			switch(i.charAt(z))
			{
				case '0':
					y = y + "0000";
					break;
				case '1':
					y = y + "0001";
					break;
				case '2':
					y = y + "0010";
					break;
				case '3':
					y = y + "0011";
					break;
				case '4':
					y = y + "0100";
					break;
				case '5':
					y = y + "0101";
					break;
				case '6':
					y = y + "0110";
					break;
				case '7':
					y = y + "0111";
					break;
				case '8':
					y = y + "1000";
					break;
				case '9':
					y = y + "1001";
					break;
				case 'a':
				case 'A':
					y = y + "1010";
					break;
				case 'b':
				case 'B':
					y = y + "1011";
					break;
				case 'c':
				case 'C':
					y = y + "1100";
					break;
				case 'd':
				case 'D':
					y = y + "1101";
					break;
				case 'e':
				case 'E':
					y = y + "1110";
					break;
				case 'f':
				case 'F':
					y = y + "1111";
					break;
			}
		}
		return y;
	}
	static private String MAC(String MAC_Data)
	{
		String s = HexBin(MAC_Data);
		char[] c = new char[128];
		for(int i = 0; i < 128; i++)
		{
			c[i] = '0';
		}
		for(int i = 0; i < s.length(); i++)
		{
			if((c[i%128] == '0' && s.charAt(i) == '0') || (c[i%128] == '1' && s.charAt(i) == '1'))
			{
				c[i%128] = '0';
			}
			else
			{
				c[i%128] = '1';
			}
		}
		return BinHex(new String(c));
	}
	public static void main(String[] args)
	{
		String s = BinHex(HexBin("00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10 11 12 13 14 15 16 17 18 19 1A 1B 1C 1D 1E 1F"));
		if(s.compareToIgnoreCase("00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10 11 12 13 14 15 16 17 18 19 1A 1B 1C 1D 1E 1F") != 0)
		{
			System.err.println("HexBin/BinHex Failed");
		}
		s = MAC("00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10 11 12 13 14 15 16 17 18 19 1A 1B 1C 1D 1E 1F");
		if(s.compareToIgnoreCase("10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10") != 0)
		{
			System.err.println("MAC Mismatch");
		}
		String Connection_ID = "d9 be ba a3 b6 5b 1c 03 c2 5d 50 40 c5 2e 84 ad dd e3 e2 96 65 95 f5 eb 1f 1f 95 06 69 25 1d b5 f9 11 01 07 d6 36 b1 45 57 a8 59 0e 97 41 82";
		String Challenge_Data = "11 5e fd c8 82 58 68 c1 3c 36 82 b1 a5 f3 0b 3e 57 f2 0a 9b 4b 96 1c b5 5c 91 63 30 16 ad b6 0a 3a 17 1b 69 40 23 74 9d 69";
		int Master_Key = 46021;
		
		String s1 = HexInt(Master_Key) + " 00 " + Challenge_Data + " " + Connection_ID;
		String s2 = HexInt(Master_Key) + " 01 " + Challenge_Data + " " + Connection_ID;
		String s3 = HexInt(Master_Key) + " 02 " + Challenge_Data + " " + Connection_ID;
		
		s1 = MAC(s1);
		s2 = MAC(s2);
		s3 = MAC(s3);
	}
}
