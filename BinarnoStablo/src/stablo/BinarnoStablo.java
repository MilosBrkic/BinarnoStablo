package stablo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BinarnoStablo<T> implements Map<Integer, T>  {
	
	private Cvor<T> koren;
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return koren==null;
	}

	@Override
	public boolean containsKey(Object key) {
		return pretraga(koren, (int)key)!=null;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(Object key) {
		return pretraga(koren, (int)key);
	}

	private T pretraga(Cvor<T> k, int kljuc){
		T levo,desno;
		
		if(k==null)
		return null;
		
		if(k.kljuc==kljuc)
			return k.podatak;
		
		if(k.kljuc>kljuc) {
			levo = pretraga(k.levi,kljuc);
			if(levo!=null)
			return levo;
		}
		
		if(k.kljuc<kljuc) {
			desno = pretraga(k.desni,kljuc);
			if(desno!=null)
			return desno;
		}
		
		return null;			
	}
	
	public void put(int key, T value) {
		Cvor<T> novi = new Cvor<T>(key, value, null, null);
		Cvor<T> pom = koren;
		
		if(koren==null) {
			koren=novi;
			return;
		}
		
		while(pom!=null) {//zamena podatka ako kljuc postoji
			if(pom.kljuc==key) {
				pom.podatak=value;
				return;
			}
			
			if(pom.kljuc>key) {
				if(pom.levi==null) {
					pom.levi = novi;
					novi.roditelj=pom;
					balans(koren);
					balansiranje(novi);
					return;
				}
				else
					pom=pom.levi;
			}
			else {
				if(pom.desni==null) {
					pom.desni = novi;
					novi.roditelj=pom;				
					balans(koren);
					balansiranje(novi);
					return;
				}
				else
					pom=pom.desni;
			}
		}
	}

	
	private void balansiranje(Cvor<T> cvor) {
		if(cvor==null)
			return;
		
		if(cvor.balans==2) {
			if(cvor.levi.balans==-1)
				rotacijaLevo(cvor.levi);
				
			rotacijaDesno(cvor);
			return;
		}
		
		if(cvor.balans==-2) {
			if(cvor.desni.balans==1)
				rotacijaDesno(cvor.desni);
			
			rotacijaLevo(cvor);
			return;
		}
		
		balansiranje(cvor.roditelj);
	}
	
	private int balans(Cvor<T> cvor) {//racuna balans cvorova
		if(cvor==null)
			return 0;
	
		int levo = balans(cvor.levi);
		int desno = balans(cvor.desni);
		cvor.balans = levo-desno;
		
		return 1+Math.max(levo,desno);	
	}
	
	
	private void rotacijaDesno(Cvor<T> cvor) {
		if(cvor.levi==null)
			return;
		
		Cvor<T> pom = cvor.levi;
		
		if (cvor.roditelj != null) {
			if (cvor.roditelj.levi==cvor)
				cvor.roditelj.levi = pom;
			else
				cvor.roditelj.desni = pom;
		}
		else 
			koren = pom;

		if(pom.desni!=null) {
			cvor.levi = pom.desni;
			pom.desni.roditelj=cvor;
		}
		else
			cvor.levi = null;
		
		pom.roditelj=cvor.roditelj;
		pom.desni= cvor;
		cvor.roditelj=pom;
	}
	
	private void rotacijaLevo(Cvor<T> cvor) {
		if(cvor.desni==null)
			return;
		
		Cvor<T> pom = cvor.desni;

		if (cvor.roditelj != null) {
			if (cvor.roditelj.levi==cvor)
				cvor.roditelj.levi = pom;
			else
				cvor.roditelj.desni = pom;	
		}
		else 
			koren = pom;

		if(pom.levi!=null) {
			cvor.desni = pom.levi;
			pom.levi.roditelj = cvor;
		}
		else 
			cvor.desni = null;
		
		pom.roditelj=cvor.roditelj;
		pom.levi= cvor;
		cvor.roditelj=pom;
	}
	
	@Override
	public T remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T put(Integer key, T value) {
		// TODO Auto-generated method stub
		return null;
	}

}
