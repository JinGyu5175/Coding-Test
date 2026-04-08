
import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static int idx;

    static String parse() {
        idx++;  // 현재 노드 문자 소비

        List<String> childShapes = new ArrayList<>();

        while (s.charAt(idx) != '#') {
            String oneChildShape = parse();
            childShapes.add(oneChildShape);
        }

        idx++;  // 현재 노드 끝 '#' 소비

        Collections.sort(childShapes);

        StringBuilder shape = new StringBuilder();
        shape.append("(");

        for (int i = 0; i < childShapes.size(); i++) {
            shape.append(childShapes.get(i));
        }

        shape.append(")");

        return shape.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 한 트리를 한 줄로 입력받고, 공백 제거
            String treeA = br.readLine().replace(" ", "");
            String treeB = br.readLine().replace(" ", "");

            s = treeA;
            idx = 0;
            String shapeA = parse();

            s = treeB;
            idx = 0;
            String shapeB = parse();

            if (shapeA.equals(shapeB)) {
                System.out.println("The two trees are isomorphic.");
            } else {
                System.out.println("The two trees are not isomorphic.");
            }
        }
    }
}