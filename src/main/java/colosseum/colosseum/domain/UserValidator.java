package colosseum.colosseum.domain;

import org.springframework.stereotype.Controller;

import java.util.Objects;

//@Controller
//public class UserValidator {
//
//	private static UserRepository userRepository;
//
//	public static void validateSave(User user) {
//		try {
//			validateSameEmail(user);
//		} catch (Exception err) {
//			System.out.println("Error : "  + err);
//		}
//	}
//
//	private static void validateSameEmail(User user) {
//		int count = (int) userRepository.finaAll()
//				.stream()
//				.filter(tmpUser -> Objects.equals(tmpUser.getEmail(), user.getEmail()))
//				.count();
//		if (count > 0) throw new IllegalArgumentException("동일한 이메일이 있습니다.");
//	}
//}
