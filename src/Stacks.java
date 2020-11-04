public class Stacks{
	char [] S;
	int topS;
	Stacks(){
		this.S = new char[1024];
		this.topS = -1;
	}
	void push(char c) {
		S[++topS] = c;
	}
	char pop() throws Error{
		if(empty())throw new Error("RE");
		return S[topS--];
	}
	char peek() {
		//An error occurs if the stack is empty
		return S[topS];
	}
	boolean empty() {
		return topS == -1;
	}
	int size() {
		return this.topS + 1;
	}
	char pri_peek() {
		if(peek() == 'E')return S[topS - 1];
		return peek();
	}
	int pri_peek_index() {
		if(peek() == 'E')return topS - 1;
		return topS;
	}
	char getchar(int index) throws Error{
		if(index < 0 || index > topS)throw new Error("RE");
		return S[index];
	}
		void Process(int at) throws Error {
		if(S[at] == 'i') {
			this.pop();
			this.push('E');
		}
		else if(this.getchar(at) == '*' || this.getchar(at) == '+') {
			if(this.getchar(at - 1) != 'E' || this.getchar(at + 1) != 'E')throw new Error("RE");
			this.pop();this.pop();this.pop();
			this.push('E');
		}
		else if(this.getchar(at) == ')') {
			if(this.getchar(at - 1) != 'E' || this.getchar(at - 2) != '(')throw new Error("RE");
			this.pop();this.pop();this.pop();
			this.push('E');
		}
		else throw new Error("RE");
	}
}