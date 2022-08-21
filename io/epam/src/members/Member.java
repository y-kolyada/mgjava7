package members;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Member {
	public ArrayList<String[]> course1;
	public ArrayList<String[]> course2;

	public static void main(String[] args) {
		System.out.println("Hello!");
		Member member = new Member();
		member.course1 = member.readFile("c:\\dev\\files\\course1_in.txt");
		member.writeFile(member.course1, "c:\\dev\\files\\course1_ou.txt");
		System.out.println("Total members on Course 1: " + member.course1.size());
		member.course2 = member.readFile("c:\\dev\\files\\course2_in.txt");
		member.writeFile(member.course2, "c:\\dev\\files\\course2_ou.txt");
		System.out.println("Total members on Course 2: " + member.course2.size());
		member.checkCourseMember(member.course1, member.course2, "c:\\dev\\files\\course_1-in-2.txt");
		System.out.println("Finished");
	}

	public Member() {
		course1 = new ArrayList<String[]>();
		course2 = new ArrayList<String[]>();
	}

	private Boolean checkCourseMember(ArrayList<String[]> courseIn,  ArrayList<String[]> course, String ouFilePath) {
		try {
			FileWriter ouFile = new FileWriter(ouFilePath);
			Iterator<String[]> iterIn = course.iterator();		
			int course2MemberCount = 0;		
			
			while (iterIn.hasNext()) {
				++course2MemberCount;
				String[] memberIn = { "", "", "", "", "" };
				memberIn = (String[]) iterIn.next();
				
				Iterator<String[]> iter = courseIn.iterator();
				
				int course1MemberCount = 0;
				while (iter.hasNext()) {
					++course1MemberCount;
					String[] member = { "", "", "", "", "" };
					member = (String[]) iter.next();
					if (member[0].equals(memberIn[0])) {
						ouFile.write("("+ course2MemberCount + ") "+ memberIn[0] + 
								" / (" + course1MemberCount + ") "+ member[0] + System.lineSeparator());
						break;
					}
				}
			}
			ouFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;		
	}  
	
	public void writeFile(ArrayList<String[]> course, String outFilePath) {
		try {
			FileWriter ouFile = new FileWriter(outFilePath);

			Iterator<String[]> iter = course.iterator();
			int i = 0;
			while (iter.hasNext()) {
				String personAttr = String.join(";", (String[]) iter.next());				
				if (course.size() != ++i) {
					personAttr = personAttr + System.lineSeparator();
				} 
				ouFile.write(personAttr);
			}
			ouFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String[]> readFile(String inFilePath) {
		InputStreamReader isr;
		BufferedReader br;
		ArrayList<String[]> members = new ArrayList<String[]>();

		File inFile = new File(inFilePath);
		try {
			FileInputStream fis = new FileInputStream(inFile);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);

			String line;

			List<String> person = new ArrayList<String>();
			List<String> personRoles = new ArrayList<String>(Arrays.asList("Guest", "Member", "Owner"));
			Set<String> roles = new HashSet<String>(personRoles);

			while ((line = br.readLine()) != null) {
				person.add(line);

				if (roles.contains(line)) {
					String[] personAttr = { "", "", "", "", "" };

					if (line.contains("Guest")) {
						personAttr[0] = person.get(1);
						personAttr[4] = "Guest";
					} else if (line.contains("Member")) {
						personAttr[0] = person.get(1);
						personAttr[1] = person.get(2);
						personAttr[2] = person.get(3);
						personAttr[4] = "Member";
					} else if (line.contains("Owner")) {
						personAttr[0] = person.get(1);
						personAttr[1] = person.get(2);
						personAttr[2] = person.get(3);
						personAttr[4] = "Guest";
					}
					person.clear();
					members.add(personAttr);
				}
			}
			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("File IO Error");
		}
		
		return members;
	}
}