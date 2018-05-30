package stablo;

public class Cvor<T> {
	
	protected int kljuc;
	protected T podatak;
	protected Cvor<T> levi;
	protected Cvor<T> desni;
	
	protected Cvor<T> roditelj = null;
	protected int balans = 0;
	
	public Cvor(int kljuc, T podatak, Cvor<T> levi, Cvor<T> desni) {
		super();
		this.kljuc = kljuc;
		this.podatak = podatak;
		this.levi = levi;
		this.desni = desni;
	}
	
	
	

}
