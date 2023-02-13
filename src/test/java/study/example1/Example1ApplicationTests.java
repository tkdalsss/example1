package study.example1;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.example1.domain.Account;
import study.example1.domain.Currency;
import study.example1.repository.AccountRepository;
import study.example1.service.AccountService;
import study.example1.service.TransferService;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class Example1ApplicationTests {

	@Autowired
	AccountService accountService;

	@Autowired
	TransferService transferService;

	@Test
	void accountTest() {

		// given
		Account save1 = accountService.createAccount(Account.createAccount("userA", 10000, Currency.EUR));
		Account save2 = accountService.createAccount(Account.createAccount("userB", 20000, Currency.KRW));

		// when
		int amount = 5000;
		transferService.transfer(save1.getId(), save2.getId(), amount);

		// then
		assertThat(save1.getBalance()).isEqualTo(5000);
		assertThat(save2.getBalance()).isEqualTo(25000);
	}

}
