package compiler.generation;

public class InstruCible {

		private String Operande;
	 private 	String Operateur;
	 
	 
		public String getOperande() {
		return Operande;
	}
	public void setOperande(String operande) {
		Operande = operande;
	}
	public String getOperateur() {
		return Operateur;
	}
	public void setOperateur(String operateur) {
		Operateur = operateur;
	}
		public InstruCible()
		{ 
			this.Operande=null;
			this.Operateur=null;
		}
		public InstruCible(String Operateur_ ,String Operande_ )
		{
			this.Operande=Operande_;
			this.Operateur=Operateur_;
		}
		
		public String  toString()
		{
			return  this.Operateur+" "+this.Operande;
		}

}
