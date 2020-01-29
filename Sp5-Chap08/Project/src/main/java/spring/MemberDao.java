package spring;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {

	private static long nextId = 0;

	private JdbcTemplate jdbcTemplate;
	
	private Map<String, Member> map = new HashMap<String, Member>();

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * 람다 사용 예
	 * @param email
	 * @return
	 */
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				(rs, rowNum) -> {
					Member member = new Member(
							rs.getString("EMAIL"),
							rs.getString("PASSWORD"),
							rs.getString("NAME"),
							rs.getTimestamp("REGDATE").toLocalDateTime());
					member.setId(rs.getLong("ID"));
					return member;
				}, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	/**
	 * RowMapper를 구현하여 사용하는 예
	 * @param email
	 * @return
	 */
	/*
	 * public Member selectByEmail(String email, String name) { List<Member> results
	 * = jdbcTemplate.query( "select * from MEMBER where EMAIL = ?, NAME = ?", new
	 * MemberRowMapper(), email, name);
	 * 
	 * return results.isEmpty() ? null : results.get(0); }
	 */
	/**
	 * 임의 클래스 사용 예
	 * @param email
	 * @return
	 */
	/*
	 * public Member selectByEmail(String email) { List<Member> results =
	 * jdbcTemplate.query( "select * from MEMBER where EMAIL = ?", new
	 * RowMapper<Member>() {
	 * 
	 * @Override public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
	 * Member member = new Member( rs.getString("EMAIL"), rs.getString("PASSWORD"),
	 * rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
	 * member.setId(rs.getLong("ID")); return member; } }, email);
	 * 
	 * return results.isEmpty() ? null : results.get(0); }
	 */

	public void insert(Member member) {
	}

	public void update(Member member) {
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER",
				(ResultSet rs, int rowNum) -> {
					Member member = new Member(
							rs.getString("EMAIL"),
							rs.getString("PASSWORD"),
							rs.getString("NAME"),
							rs.getTimestamp("REGDATE").toLocalDateTime());
					member.setId(rs.getLong("ID"));
					return member;
				});
		return results;
	}
}
