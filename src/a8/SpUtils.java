package a8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import spiffy.core.util.*;

public class SpUtils {
	
	public static List<Integer[]> readFile(String path){
		
		final File file = new File(path);
		List<Integer[]> content = new ArrayList<>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
			
			String tmp = "";
			String[] row = new String[3];
			
			while((tmp = bufferedReader.readLine()) != null){
				row = tmp.split("\t");
				content.add(new Integer[]{
						Integer.valueOf(row[0]),
						Integer.valueOf(row[1]),
						Integer.valueOf(row[2])
				});
			}
		}catch (IOException e) {
			System.out.println("Problems while reading file " + path);
		}
		
//		for(int i = 0; i < content.size(); i++){
//			System.out.println(content.get(i)[0] + "     " + content.get(i)[1] + "     " + content.get(i)[2]);
//		}
		
		return content;
	}
	
	public static void printChangedValues(List<Integer[]> list){
		System.out.println("Shorened values:");
		for(Integer[] item : list){
			String old = (item[2] == Integer.MAX_VALUE)?("oo"):(item[2].toString());
			String curr = (item[3] == Integer.MAX_VALUE)?("oo"):(item[3].toString());
			System.out.format("Pos [%3d,%3d]:    %3s --> %3s%n", item[0], item[1], old, curr);
		}
	}
	
	public static void print2dMap(TwoDHashMap<Integer, Integer, Integer> map, int dimension, String message){
		System.out.println("______________________________________");
		System.out.println(message);
		for(int i = 1; i <= dimension; i++){
			if(i == 1){
				System.out.format("[%3s]", "-");
				for(int columns = 1; columns <= dimension; columns++){
					System.out.format("[%3s]", columns);
				}
				System.out.println();
			}
			for(int j = 1; j <= dimension; j++){
				if(j == 1){
					System.out.format("[%3s]", i);
				}
				System.out.format("%5s", (map.get(i, j) == Integer.MAX_VALUE)?("oo"):(map.get(i, j)).toString());
			}
			System.out.println();
		}
	}
}


