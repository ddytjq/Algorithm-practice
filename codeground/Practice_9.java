import java.util.Scanner;

public class Practice_9{
	public static void main(String args[]) throws Exception	{        
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			String idx = sc.next().toLowerCase();
			char[] num = new char[idx.length()];
			for(int i = 0; i < idx.length(); i++)
				num[i] = idx.charAt(i);
			String table = "H He Li Be B C N O F Ne Na Mg Al Si P S Cl Ar K Ca Sc Ti V Cr Mn Fe Co Ni Cu Zn Ga Ge As Se Br Kr Rb Sr Y  Zr Nb Mo Tc Ru Rh Pd Ag Cd In Sn Sb Te I Xe Cs Ba La Ce Pr Nd Pm Sm Eu Gd Tb Dy Ho Er Tm Yb Lu Hf Ta W Re Os Ir Pt Au Hg Tl Pb Bi Po At Rn Fr Ra Ac Th Pa U Np Pu Am Cm Bk Cf Es Fm Md No Lr Rf Db Sg Bh Hs Mt Ds Rg Cn Fl Lv";
			table.toLowerCase();
			String[] table2 = table.split(" ");
			boolean result = false;
			int start = 0;
			String a = "";
			while(start <= idx.length()-1){
				a = "";
				a = a + num[start];
				if(start < idx.length()-1){
					for(int i = 0; i < table2.length; i++){
						if(start < idx.length()-1&&a.equals(table2[i].toLowerCase())){
							result = true;
							start = start + 1;}
					}
					for(int i = 0; i < table2.length; i++){
						if(start < idx.length()-1&&!a.equals(table2[i].toLowerCase())){
							a = a + num[start+1];
							if(a.equals(table2[i].toLowerCase())){
								result = true;
								start = start + 2;
							}
							else{
								result = false;
								start = start + 2;
							}
						}
					}
				}
				else if(start == idx.length()-1){
					for(int i = 0; i < table2.length; i++){
						if(a.equals(table2[i].toLowerCase())){
							result = true;
							start = start + 1;}
						else{
							result = false;
							start = start + 1;}
					}
				}
			}
			System.out.println("Case #" + test_case);
			if(result == true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}