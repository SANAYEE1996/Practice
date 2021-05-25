import java.sql.*;
import java.util.*;

public class JDBCTest {

	private static int result;

	public static void main(String[] args) {

		String sid, sname, deptno, advisor, gen, addr, birthdate, grade, dname, pname;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@dbserver.yu.ac.kr:1521:XE", "student136",
					"kaka");
			Statement stmt = conn.createStatement();

			PreparedStatement pstmt = null;
			int MenuNum = 0;

			while (MenuNum != 6) {
				System.out.println("1.학생추가, 2:학생 삭제, 3.학생 수정, 4:학생 검색, 5:학과 출력, 6:종료");

				Scanner sc = new Scanner(System.in);

				String sql1 = "insert into student(sid, sname, deptno, advisor, gen, addr, birthdate, grade) values(?,?,?,?,?,?,?,?)";
				String sql2 = "delete from student where sid = ?";
				String sql3 = "update student set sname = ?, deptno = ?, advisor = ?, gen = ?, addr = ?, birthdate = ?, grade = ? where sid = ?";
				String sql4 = "select * from student where sid = ?";
				String sql5 = "select sid, sname, dname, pname from student s, department d, professor p "
						+ "where s.deptno = d.deptno and s.advisor = p.pid(+) and s.deptno = ?";

				MenuNum = sc.nextInt();
				sc.nextLine();

				switch (MenuNum) {
				case 1:
					try {

						int result ;
						
						
						System.out.println("입력할 학번 : ");
						sid = sc.nextLine();
						if(sid.equals(""))
							sid = null;							
						System.out.println("입력할 학생이름 : ");
						sname = sc.nextLine();
						if(sname.equals(""))
							sname = null;
						System.out.println("입력할 학과번호 : ");
						deptno = sc.nextLine();
						if(deptno.equals(""))
							deptno= null;
						System.out.println("입력할 교수번호 : ");
						advisor = sc.nextLine();
						if(advisor.equals(""))
							advisor = null;
						System.out.println("입력할 성별 : ");
						gen = sc.nextLine();
						if(gen.equals(""))
							gen = null;
						System.out.println("입력할 주소 : ");
						addr = sc.nextLine();
						if(addr.equals(""))
							addr = null;
						System.out.println("입력할 생년월일 : ");
						birthdate = sc.nextLine();
						if(birthdate.equals(""))
							birthdate = null;
						System.out.println("입력할 성적 : ");
						grade = sc.nextLine();
						if(grade.equals(""))
							grade = null;

						pstmt = conn.prepareStatement(sql1);
						pstmt.setString(1, sid);
						pstmt.setString(2, sname);
						pstmt.setString(3, deptno);
						pstmt.setString(4, advisor);
						pstmt.setString(5, gen);
						pstmt.setString(6, addr);
						pstmt.setString(7, birthdate);
						pstmt.setString(8, grade);
						result = pstmt.executeUpdate();
							

						System.out.println("입력이 완료되었습니다");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
						System.exit(0);
					}
					break;
				case 2:
					try {

						int result = 0;

						System.out.println("지울 학번 : ");
						sid = sc.next();

						pstmt = conn.prepareStatement(sql2);
						pstmt.setString(1, sid);

						result = pstmt.executeUpdate();

						System.out.println("삭제가 완료되었습니다");

					} catch (SQLException e) {
						System.out.println(e.getMessage());
						System.exit(0);
					}
					break;
				case 3:
					try {

						String sname1, deptno1, advisor1, gen1, addr1, birthdate1, grade1;

						System.out.println("수정할 학번 : ");
						sid = sc.next();

						pstmt = conn.prepareStatement(sql4);
						pstmt.setString(1, sid);
						ResultSet result1 = pstmt.executeQuery();
						while (result1.next()) {
							sid = result1.getString(1);
							sname1 = result1.getString(2);
							deptno1 = result1.getString(3);
							advisor1 = result1.getString(4);
							gen1 = result1.getString(5);
							addr1 = result1.getString(6);
							birthdate1 = result1.getString(7);
							grade1 = result1.getString(8);
							System.out.println(sid + "     " + sname1 + "	" + deptno1 + "     " + advisor1 + "     "
									+ gen1 + "     " + addr1 + "     " + birthdate1 + "     " + grade1);

						}

						int result = 0;

						System.out.println("수정할 애 이름 : ");
						sname = sc.next();
						System.out.println("수정할 애 학과번호 : ");
						deptno = sc.next();
						System.out.println("수정할 애 지도교수 번호 : ");
						advisor = sc.next();
						System.out.println("수정할 애 성별 : ");
						gen = sc.next();
						System.out.println("수정할 애 주소 : ");
						addr = sc.next();
						System.out.println("수정할 애 생년월일 : ");
						birthdate = sc.next();
						System.out.println("수정할 애 학점 : ");
						grade = sc.next();

						pstmt = conn.prepareStatement(sql3);
						pstmt.setString(1, sname);
						pstmt.setString(2, deptno);
						pstmt.setString(3, advisor);
						pstmt.setString(4, gen);
						pstmt.setString(5, addr);
						pstmt.setString(6, birthdate);
						pstmt.setString(7, grade);
						pstmt.setString(8, sid);

						result = pstmt.executeUpdate();

						System.out.println("수정이 완료되었습니다");

					} catch (SQLException e) {
						System.out.println(e.getMessage());

					}
					break;
				case 4:
					try {

						System.out.println("검색할 학번 : ");
						sid = sc.next();

						pstmt = conn.prepareStatement(sql4);
						pstmt.setString(1, sid);

						ResultSet result = pstmt.executeQuery();
						while (result.next()) {
							sid = result.getString(1);
							sname = result.getString(2);
							deptno = result.getString(3);
							advisor = result.getString(4);
							gen = result.getString(5);
							addr = result.getString(6);
							birthdate = result.getString(7);
							grade = result.getString(8);
							System.out.println(sid + "     " + sname + "		" + deptno + "     " + advisor + "     "
									+ gen + "     " + addr + "     " + birthdate + "     " + grade);
						}

						System.out.println("출력이 완료되었습니다");

					} catch (Exception e) {

					}
					break;
				case 5:
					try {

						System.out.println("학과 번호 입력 : ");
						deptno = sc.next();

						pstmt = conn.prepareStatement(sql5);
						pstmt.setString(1, deptno);

						ResultSet result = pstmt.executeQuery();
						while (result.next()) {
							sid = result.getString(1);
							sname = result.getString(2);
							dname = result.getString(3);
							pname = result.getString(4);
							System.out.println(sid + "     " + sname + "     " + dname + "     " + pname);
						}

						System.out.println("검색이 완료되었습니다");

					} catch (Exception e) {

					}
					break;
				case 6:
					stmt.close();
					conn.close();
					break;

				default:
					System.out.println("다시 하세요! 이런");
				}

			}

		} catch (SQLException sqle) {
			System.out.println("SQLException : " + sqle);
		}

	}

}
