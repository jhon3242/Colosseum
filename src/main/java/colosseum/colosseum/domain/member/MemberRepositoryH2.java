package colosseum.colosseum.domain.member;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryH2 implements MemberRepository {

	private final JdbcTemplate template;
	private static Long sequence = 3L;

	public MemberRepositoryH2(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}


	@Override
	public Member save(Member user) {

		String sql = "insert into \"USER\" (ID) values(?);"; // TODO add more data
		user.setId(++sequence);
		template.update(sql, user.getId());
		return user;
	}

	@Override
	public Member findById(Long id) {
		return null;
	}

	@Override
	public Optional<Member> findByEmail(String email) {
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return null;
	}
}
