package ruolan.com.myhearts.utils;


import java.util.Comparator;

import ruolan.com.myhearts.entity.CityModel;

public class PinyinComparator implements Comparator<CityModel> {

	public int compare(CityModel o1, CityModel o2) {
		if (o1.getFirstName().equals("@") || o2.getFirstName().equals("#")) {
			return -1;
		} else if (o1.getFirstName().equals("#") || o2.getFirstName().equals("@")) {
			return 1;
		} else {
			return (o1.getFirstName()).compareTo(o2.getFirstName());
		}
	}

}
