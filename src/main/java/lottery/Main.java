package lottery;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import lottery.view.InputView;
import lottery.view.ResultView;

public class Main {

	private static InputView inputView;
	private static ResultView resultView;
	private static Scanner sc;
	private static Store store;
	private static InfoCenter infoCenter;

	public static void init(){
		inputView = new InputView();
		resultView = new ResultView();
		sc = new Scanner(System.in);
		store = new Store();
		infoCenter = new InfoCenter();
	}
	public static void main(String[] args) {
		init();

		inputView.askForBuyerMoney();
		Money initialMoney = Money.won(Long.parseLong(sc.nextLine().trim()));
		Buyer buyer = Buyer.of(initialMoney);

		buyer.buyTicket(store);
		Tickets tickets = buyer.tickets();
		inputView.inputCountOfTickets(tickets.size());
		inputView.printTickets(tickets);

		inputView.askForLastWeekTickets();
		Set<Integer> ints = Arrays.stream(sc.nextLine().split(","))
			.map(a -> Integer.parseInt(a.trim()))
			.sorted()
			.collect(Collectors.toCollection(LinkedHashSet::new));
		Ticket lastWeekTicket = Ticket.of(LottoNumbers.from(ints));

		inputView.askForBonusNumber();
		int bonus = Integer.parseInt(sc.nextLine().trim());
		infoCenter.setLastWeekWinningTicket(new WinningTicket(lastWeekTicket, bonus));

		Result result = buyer.checkTicket(infoCenter);
		float totalYield = result.getTotalYield(initialMoney);
		resultView.printResult(result, totalYield);
	}
}
