package woopaca.practice.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartView {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public StartView() throws IOException {
        System.out.println("안녕하세요. 우파카마켓입니다.\n회원이신가요? [y/n]");
        String input = br.readLine();

        MemberView memberView = new MemberView();

        if (input.equals("y")) {
            memberView.isMember();
            return;
        }
        if (input.equals("n")) {
            memberView.isNotMember();
            return;
        }

        throw new IllegalArgumentException();
    }
}
