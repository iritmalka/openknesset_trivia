package com.example.knessettrivia;

import java.util.ArrayList;
import java.util.Random;

public class RandomHelper {

	private ArrayList<Integer> numbers;
	private int index;
	
	public RandomHelper(int range){
		numbers = new ArrayList<Integer>();   
		Random randomGenerator = new Random();
		while (numbers.size() < range) {

			int random = randomGenerator.nextInt(range);
			if (!numbers.contains(random)) {
				numbers.add(random);
			}
		}
		index = 0;
	}
	
	private void updateIndex(){
		index++;
		if (index == numbers.size()-1){
			index = 0;
		}
	}

	public void initialize(){
		index = 0;
	}
	
	public int next(){
		int next = numbers.get(index);
		updateIndex();
		return next;
	}

}