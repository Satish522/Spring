package beans.service;

import java.util.Random;

public class KeyGenerator {
	public int generateKey(int size)  {
		Random random=new Random(size);
		random.setSeed(5);
		int generatedKey=random.nextInt();
		if(generatedKey<=0) {
			throw new RuntimeException("Weak Key Generated");
		}
		return generatedKey;
	}
	 
}
