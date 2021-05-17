
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Share> SetShare = new ArrayList<>();
		int menu = 0;
		System.out.println("BJ - Share");
		while(true) {
			System.out.println("\nOption : ");
			System.out.println("1. Start Sharing");
			System.out.println("2. Update Participant");
			System.out.println("3. Delete Participant");
			System.out.println("4. Close App");
			System.out.print("Choice >> ");
			menu = scan.nextInt();
			scan.nextLine();
			if(menu == 1) {
				String num1, name;
				do {
					System.out.print("Input a number [1- 100] : ");
					num1 = scan.nextLine();
					if(!Share.isNumeric(num1)) {
						System.out.println("Input must be numeric");
						num1 = "101";
					}
				} while(Integer.parseInt(num1) < 0 || Integer.parseInt(num1) > 100);
				while(true) {
					System.out.print("Could you give me your username [5 - 20 characters] : ");
					name = scan.nextLine();
					if(!isDuplicate(SetShare, name)) {
						System.out.println("Username has already been taken!!");
					} else {
						SetShare.add(new Share(Integer.parseInt(num1), name));
						System.out.println("You are the " + SetShare.size() + " that joins the game");
						break;
					}
				}
				System.out.print("You share number : " + num1);
			} else if(menu == 2 && !SetShare.isEmpty()) {
				int count = 1;
				String participantNum;
				System.out.println("Share List");
				for (Iterator iterator = SetShare.iterator(); iterator.hasNext();) {
					Share share = (Share) iterator.next();
					System.out.println(count++ + "\t" + share.username + "\t" + share.numShare);
				}
				do {
					System.out.print("Which participant you would like to update [1 - " + SetShare.size() + "][0 to exit] ? ");
					participantNum = scan.nextLine();
					if(!Share.isNumeric(participantNum)) {
						System.out.println("Input must be numeric");
						participantNum = "-1";
					}
				} while(Integer.parseInt(participantNum) < 0 || Integer.parseInt(participantNum) > SetShare.size());
				if(Integer.parseInt(participantNum) != 0) {
					int numTemp = -1;
					while(numTemp < 0 || numTemp > 100) {
						System.out.print("Input a number [1- 100] : ");
						numTemp = scan.nextInt();
					}
//					assertThat(SetShare).hasSize(3);
					int participantNumT = Integer.parseInt(participantNum);
					for (Iterator iterator = SetShare.iterator(); iterator.hasNext();) {
						Share share = (Share) iterator.next();
						if(participantNumT == 1) {
							share.numShare = numTemp;
							System.out.println("Update Successful!");
							break;
						}
						participantNumT--;
					}
				}
			} else if(menu == 3 && !SetShare.isEmpty()) {
				int count = 1;
				String participantNum;
				System.out.println("Share List");
				for (Iterator iterator = SetShare.iterator(); iterator.hasNext();) {
					Share share = (Share) iterator.next();
					System.out.println(count++ + "\t" + share.username + "\t" + share.numShare);
				}
				do {
					System.out.print("Which participant you would like to delete [1 - " + SetShare.size() + "][0 to exit] ? ");
					participantNum = scan.nextLine();
					if(!Share.isNumeric(participantNum)) {
						System.out.println("Input must be numeric");
						participantNum = "-1";
					}
				} while(Integer.parseInt(participantNum) < 0 || Integer.parseInt(participantNum) > SetShare.size());
				if(Integer.parseInt(participantNum) != 0) {
					int participantNumT = Integer.parseInt(participantNum);
					SetShare.remove(participantNumT-1);
					System.out.println("Participant successfully removed from event");
				}
			} else if(menu == 4) {
				System.out.println("Here's the completed share list");
				System.out.println("Remember, sharing is caring, happy sharing :D");
				System.out.println("Share List");
				System.out.println("Username\t\tBefore\tAfter");
				Collections.sort(SetShare, (p1, p2) -> p1.username.compareTo(p2.username));
				ArrayList<Share> alTemp = new ArrayList<Share>(SetShare);
				Collections.copy(alTemp, SetShare);
				Collections.shuffle(alTemp);
				Collections.reverse(alTemp);
				Iterator iterator = SetShare.iterator();
				Iterator itTambahan = alTemp.iterator();
				while (iterator.hasNext()) {
					Share share = (Share) iterator.next();
					Share share2 = (Share) itTambahan.next();
					System.out.println(share.username + "\t\t\t" + share.numShare + "\t" + share2.numShare);
				}
				break;
			}
		}
		scan.close();
	}
	
	public static boolean isDuplicate(ArrayList<Share> s, String SInput) { 
		for (Iterator iterator = s.iterator(); iterator.hasNext();) {
			Share share = (Share) iterator.next();
			if(SInput.equals(share.username)) {
				return false;
			}
		}
		
		return true;
	}

}
