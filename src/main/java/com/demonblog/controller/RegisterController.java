//package com.demonblog.controller;
//
//import com.demonblog.exception.RegisterErrorException;
//import com.demonblog.model.Register;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/security")
//
//public class RegisterController {
//
//	private static final List<Register> REGISTER_LIST = Arrays.asList(
//			new Register(1, "okoroaforkelechi123@gmai.com",
//					"kelechiDivine",
//					"08082167764",
//					"keLechi5363@#",
//					"keLechi5363@#"
//			),
//
//			new Register(2, "kdivine892@gmail.com",
//					"kdivine892@gmail.com",
//					"08022296411",
//					"loveEverywhere",
//					"loveEverywhere"),
//
//			new Register(3, "omololaesther@gmail.com",
//					"omololaesther@gmail.com",
//					"080122454545",
//					"mymaniskelechi",
//					"mymaniskelechi")
//	);
//
//
//	@GetMapping(path = "{registerId}")
//	public Register getRegister(@PathVariable("registerId") Integer registerId) throws RegisterErrorException {
//		return REGISTER_LIST.stream()
//				.filter(register -> registerId.equals(register.getRegisterId()))
//				.findFirst()
//				.orElseThrow(() -> new RegisterErrorException("A user with id " + registerId + " doesn't exist"));
//	}
//
//}
