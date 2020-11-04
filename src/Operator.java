

public class Operator {
	static char [][] pri_operator = {
			{'>','<','<','<','>','>'},
			{'>','>','<','<','>','>'},
			{'>','>',' ',' ','>','>'},
			{'<','<','<','<','=',' '},
			{'>','>',' ',' ','>','>'},
			{'<','<','<','<',' ','='}
	};
	static private int operator_index(char oper) throws Error{
		switch(oper) {
			case '+':
				return 0;
			case '*':
				return 1;
			case 'i':
				return 2;
			case '(':
				return 3;
			case ')':
				return 4;
			case '#':
				return 5;
			default:
				throw new Error("E");
		}
	}
	static public char pri_compare(char oper1, char oper2) throws Error{
		int x1 = operator_index(oper1);
		int x2 = operator_index(oper2);
		if (pri_operator[x1][x2] == ' ')
			throw new Error("E");
		else
			return pri_operator[x1][x2];
	}
}
