package entityFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import valueObject.HWInfo;

public class HW {

	public void setMyHWList() {
		Vector<HWInfo> myHWList = getMyHWList();
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("myHW.txt");
			bw = new BufferedWriter(fw);

			for (int i = 0; i < myHWList.size(); i++) {
				bw.write(myHWList.get(i).getNumber() + " " + myHWList.get(i).getName());
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	public void putList(Vector<HWInfo> HWlist) {

	}

	public Vector<HWInfo> getMyHWList() {
		Vector<HWInfo> myHWList = new Vector<HWInfo>();

		myHWList.add(new HWInfo("1", "oop1"));
		myHWList.add(new HWInfo("2", "oop2"));
		myHWList.add(new HWInfo("3", "mechanic1"));
		myHWList.add(new HWInfo("4", "mechanic2"));

		return myHWList;
	}

	public Vector<HWInfo> readMyHWFile() {
		Vector<HWInfo> HWFile = new Vector<HWInfo>();
		FileReader fr = null;
		BufferedReader br = null;
		String data;
		try {
			fr = new FileReader("myHW.txt");
			br = new BufferedReader(fr);
			String[] temp;
			while ((data = br.readLine()) != null) {
				temp = data.split(" ");
				HWFile.add(new HWInfo(temp[0], temp[1]));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 열었던 순서 반대로 닫아줘야함.
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}

		return HWFile;
	}

}
