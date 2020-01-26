package ticTackToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe{

	static final String[] cross = {"#     #",
					   			   " #   # ",
							       "   #   ",
							       " #   # ",
								   "#     #"};
	
	static final String[] nought = {"  ###  ",
									" #   # ",
									"#     #",
									" #   # ",
									"  ###  "};
	
	static String[] pos1 = {"       ","       ","       ","       ","       "};
	static String[] pos2 = {"       ","       ","       ","       ","       "};
	static String[] pos3 = {"       ","       ","       ","       ","       "};
	static String[] pos4 = {"       ","       ","       ","       ","       "};
	static String[] pos5 = {"       ","       ","       ","       ","       "};
	static String[] pos6 = {"       ","       ","       ","       ","       "};
	static String[] pos7 = {"       ","       ","       ","       ","       "};
	static String[] pos8 = {"       ","       ","       ","       ","       "};
	static String[] pos9 = {"       ","       ","       ","       ","       "};
	
	static String[] names = {" "," "};
	static char[] ox = {'X','O'};
	static int turnIndex = 0; 
	static int choice;
	static boolean gameOver = false;
	static Scanner keyboard = new Scanner(System.in);
	static Random rand = new Random();
	
	static char[] board = new char[9];
	
	public static void main( String[] args ){
		
		

		initBoard();
		
		System.out.print("Enter player 1 name: ");
		names[rand.nextInt(2)] = keyboard.nextLine();
		
		System.out.print("Enter player 2 name: ");
		if (names[0] == " ") {
			names[0] = keyboard.nextLine();	
		}
		else {
			names[1] = keyboard.nextLine();
			
		}
		System.out.println("\n\n\n\n");
		displayBoard();
		while(hasWinner() == false && isDraw() == false) {
		choice = 99;
		
		takeTurn();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
		displayBoard();
		System.out.println("\n\n\n\n");
		}
		
		if (isDraw()) {
			System.out.println("Its a Draw!!!!\n\n\n");
		}
		else {
			displayBoard();
		
			if (turnIndex == 0) {
				System.out.printf("Game Over!\n\n"
					+	 "%s wins!! (%c's).\n\n\n",names[1],ox[1]);
			}
			else {
			System.out.printf("Game Over!\n\n"
					+	 "%s wins!! (%c's).\n\n\n",names[0],ox[0]);
		}
		}
		
	}

	private static boolean isDraw() {
		boolean result = true;
		for(char item : board) {
			if (item  != 'X' && item != 'O') {
				result = false;
			}
		}
		return result;
	}

	public static void takeTurn(){
		if (turnIndex == 0){
			System.out.printf("%s's Turn (%c's)\n"
						    + "Please select a position: \n\n",names[turnIndex],ox[turnIndex]);
			choice = keyboard.nextInt();
			
			if(validMove(choice)) {
				board[choice-1] = ox[turnIndex];
				turnIndex ++;
				}
				
				}
			
		else {
			System.out.printf("%s's Turn (%c's)\n"
							+ "Please select a position: \n\n",names[turnIndex],ox[turnIndex]);
			choice = keyboard.nextInt();
			
			if(validMove(choice)) {
				board[choice-1] = ox[turnIndex];
				turnIndex --;
			}
			
			
		}
	
	}
		
		
	public static void initBoard()
	{
		
		for(int i = 0; i < board.length; i++) {
			String currentChar = Integer.toString(i+1);
			board[i] = currentChar.charAt(0);
		}
	}

	public static void refreshBoard() {
		if (board[0] == 'X') {
			pos1 = cross;
		}
		else if(board[0] == 'O') {
			pos1 = nought;
		}
		if (board[1] == 'X') {
			pos2 = cross;
		}
		else if(board[1] == 'O') {
			pos2 = nought;
		}
		if (board[2] == 'X') {
			pos3 = cross;
		}
		else if(board[2] == 'O') {
			pos3 = nought;
		}
		if (board[3] == 'X') {
			pos4 = cross;
		}
		else if(board[3] == 'O') {
			pos4 = nought;
		}
		if (board[4] == 'X') {
			pos5 = cross;
		}
		else if(board[4] == 'O') {
			pos5 = nought;
		}
		if (board[5] == 'X') {
			pos6 = cross;
		}
		else if(board[5] == 'O') {
			pos6 = nought;
		}
		if (board[6] == 'X') {
			pos7 = cross;
		}
		else if(board[6] == 'O') {
			pos7 = nought;
		}
		if (board[7] == 'X') {
			pos8 = cross;
		}
		else if(board[7] == 'O') {
			pos8 = nought;
		}
		if (board[8] == 'X') {
			pos9 = cross;
		}
		else if(board[8] == 'O') {
			pos9 = nought;
		}
		
	}
	
	public static void displayBoard() {
		
		refreshBoard();
		
		System.out.println("\n");
		System.out.println("--------------------------------");
		System.out.println("\n");
		System.out.printf("  %7s | %7s | %7s\n",pos1[0],pos2[0],pos3[0]);
		System.out.printf("  %7s | %7s | %7s\n",pos1[1],pos2[1],pos3[1]);
		System.out.printf("  %7s | %7s | %7s\n",pos1[2],pos2[2],pos3[2]);
		System.out.printf("  %7s | %7s | %7s\n",pos1[3],pos2[3],pos3[3]);
		System.out.printf("  %7s1| %7s2| %7s3\n",pos1[4],pos2[4],pos3[4]);
		System.out.println(" ---------+---------+---------");
		System.out.printf("  %7s | %7s | %7s\n",pos4[0],pos5[0],pos6[0]);
		System.out.printf("  %7s | %7s | %7s\n",pos4[1],pos5[1],pos6[1]);
		System.out.printf("  %7s | %7s | %7s\n",pos4[2],pos5[2],pos6[2]);
		System.out.printf("  %7s | %7s | %7s\n",pos4[3],pos5[3],pos6[3]);
		System.out.printf("  %7s4| %7s5| %7s6\n",pos4[4],pos5[4],pos6[4]);
		System.out.println(" ---------+---------+---------");
		System.out.printf("  %7s | %7s | %7s\n",pos7[0],pos8[0],pos9[0]);
		System.out.printf("  %7s | %7s | %7s\n",pos7[1],pos8[1],pos9[1]);
		System.out.printf("  %7s | %7s | %7s\n",pos7[2],pos8[2],pos9[2]);
		System.out.printf("  %7s | %7s | %7s\n",pos7[3],pos8[3],pos9[3]);
		System.out.printf("  %7s7| %7s8| %7s9\n",pos7[4],pos8[4],pos9[4]);
		System.out.println("\n");
		System.out.println("--------------------------------");
		System.out.println("\n");
	}

	
	public static void printState(char[] board) {
		
		for(char pos : board) {
			System.out.println(pos);
		}
		
		
	}
	
	public static boolean hasWinner() {
		
		char pos1 = board[0];
		char pos2 = board[1];
		char pos3 = board[2];
		char pos4 = board[3];
		char pos5 = board[4];
		char pos6 = board[5];
		char pos7 = board[6];
		char pos8 = board[7];
		char pos9 = board[8]; 
		
		
		if (pos1 == pos2 && pos2 == pos3 ||
				pos4 == pos5 && pos5 == pos6 ||
				pos7 == pos8 && pos8 == pos9 ||
				pos1 == pos4 && pos4 == pos7 ||
				pos2 == pos5 && pos5 == pos8 ||
				pos3 == pos6 && pos6 == pos9 ||
				pos1 == pos5 && pos5 == pos9 ||
				pos3 == pos5 && pos5 == pos7) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean validMove(int pos) {
		boolean result = false;
		
		if(pos > 0 && pos < 10) {
			result = (board[pos-1] != 'X' && board[pos-1] != 'O');
		}
		return result;
	}
}
		




/*
		//test crosses
		pos1 = cross;
		pos2 = cross;
		pos3 = cross;
		pos4 = cross;
		pos5 = cross;
		pos6 = cross;
		pos7 = cross;
		pos8 = cross;
		pos9 = cross;
		displayBoard();
		
		//test nought
		pos1 = nought;
		pos2 = nought;
		pos3 = nought;
		pos4 = nought;
		pos5 = nought;
		pos6 = nought;
		pos7 = nought;
		pos8 = nought;
		pos9 = nought;	
		displayBoard();
*/