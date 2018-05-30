package main;

import stablo.BinarnoStablo;

public class Main {

	public static void main(String[] args) {
		BinarnoStablo<String> bs = new BinarnoStablo<String>();

		bs.put(1, "pera");
		bs.put(2, "zika");
		bs.put(3, "kuca");
		bs.put(4, "oblak");
		bs.put(5, "bla");
		bs.put(6, "neko");
		bs.put(0, "bla");
		bs.put(-1, "jabuka");

		System.out.println(bs.get(4));
	}

}
