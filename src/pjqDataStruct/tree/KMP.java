package pjqDataStruct.tree;

public class KMP {
	
	public static void main(String[] args) {
		String str = "acbcabadabad";
		String match = "abab";
		int a = isPattern(str,match);
		System.out.println(a);;
	}
	
	
	public static int isPattern(String str,String match) {
		
		int i = 0;
		int j = 0;
		int next[] = getNext(match);
		
		while(i < str.length() && j < match.length()) {
			if(j == -1 || str.charAt(i) == match.charAt(j)) {
				System.out.println(i + "  " + j);
				++i;  ++j;
			}else {
				j = next[j];
			}
		}
		if(j == match.length()) {
			return i -j;
		}else {
			return -1;
		}
	}
	
	
	public static int[] getNext(String match) {
		int[] next = new int[match.length() + 1];
		next[0] = -1;
		next[1] = 0;
		for(int i = 2; i <= match.length(); ++i) {
			int j = i;
			while(j != 0) {
				//字符比较
				if(match.charAt(i-1) == match.charAt(next[j-1])){
					next[i] = next[j-1] + 1;
					break;
				}else {
					// 获取最长前缀的最长匹配长度，得到要比较的j的位置
					j = next[j-1];
				}
			}
		}
		return next;
	}

	public static int[] getNext2(String str) {
		int[] next = new int[str.length() + 1];
		char[] match = str.toCharArray();
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		int k = -1;
		while(i <= match.length ) {
			if(k == -1 || match[i] == match[k]) {
				next[i] = ++k;
			}else {
				k = next[k];
			}
		}
		

		return next;
	}
}
