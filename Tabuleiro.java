public class Tabuleiro {
	//atributos
	Peca tab[][];
	
	//metodos
	
	Peca [][] inicia () { //inicializa o tabuleiro
		Peca tab [][] = new Peca [7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				
				if (j == 4 && i == 4) { //posicao do meio
					tab[i][j].existe = 0; // comeca vazio
				}
				else if (j < 2 || j > 5) { //se estiver nas extremidades
					if (i > 1 && i < 6) {
						tab[i][j].existe = 1; //a peca P existe dentro do tabuleiro
					}
					else {
						tab[i][j].existe = 2;
					}
				}
				else {
					tab[i][j].existe = 1;
				}
			}
		}
		
		return tab;
	}
	
	char traduz (int letra) {
		if (letra == 1)
			return 'a';
		else if (letra == 2)
			return 'b';
		else if (letra == 3) 
			return 'c';
		else if (letra == 4)
			return 'd';
		else if (letra == 5)
			return 'e';
		else if (letra == 6)
			return 'f';
		else
			return 'g';
	}
	
	void imprime () {
		for (int i  = 7; i > 0; i--) {
			System.out.print (i);
			for (int j = 0; j < 7; j++) {
				if (tab[i][j].existe == 0) //se a posicao do tabuleiro estives vazia
					System.out.print ('-');
				else if (tab[i][j].existe == 1) //se houver peca na posicao
					System.out.print('P');
			}
			System.out.print("\n");
		}
		System.out.println ("a b c d e f g");
	}
	
	void movimento (int lFinal, int cFinal, int lInicial, int cInicial) { //ver direito coordenadas
		//ver se a posicao final esta vazia
		if (tab[lFinal][cFinal].existe == 0) {
			//ver se existe peca na frente da peca e antes do buraco
			if (cFinal == cInicial) { //se a coluna e a mesma
				
				if (lFinal - lInicial == 1) { //ver se a distancia dos pontos e um
					if (tab[lFinal - lInicial][cFinal].existe == 1) { //se tiver peca realiza o movimento
						tab[lFinal - lInicial][cFinal].existe = 0; //a peca entre os dois foi comida
						tab[lFinal][cFinal].existe = 1; //a peca esta agora na posicao final
						tab[lInicial][cInicial].existe = 0; //a peca saiu da posicao inicial que agora esta vazia
					}
				}
				else if (lInicial - lFinal == 1) { //achar a coordenada do ponto entre os dois
					if (tab[lInicial - lFinal][cFinal].existe == 1) {
						tab[lInicial - lFinal][cFinal].existe = 0;
						tab[lInicial][cInicial].existe = 0;
						tab[lFinal][cFinal].existe = 1;
					}
				}
			}
			
			else if (lInicial == lFinal) { //se a linha e a mesma
				
				if (cFinal - cInicial == 1) {
					if (tab[lFinal][cFinal - cInicial].existe == 1) {
						tab[lFinal][cFinal - cInicial].existe = 0;
						tab[lInicial][cInicial].existe = 0;
						tab[lFinal][cFinal].existe = 1;
					}
				}
				
				else if (cInicial - cFinal == 1) {
					if (tab[lFinal][cInicial - cFinal].existe == 1) {
						tab[lFinal][cInicial - cFinal].existe = 0;
						tab[lInicial][cInicial].existe = 0;
						tab[lFinal][cFinal].existe = 1;
					}
				}
			}
			imprime ();
		}
	}
	
}
