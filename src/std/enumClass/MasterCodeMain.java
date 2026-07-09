package std.enumClass;

import java.util.List;

public class MasterCodeMain {
    public static void main(String[] args) {
        var masterCode = LectureMethod.OFF_LINE;

        IO.println(masterCode.name());
        IO.println(masterCode.masterCode());
        IO.println(masterCode.langCode());
        IO.println(masterCode.groupCode());
       
        IO.println(List.of(LectureMethod.values()));

        var result = List.of(LectureMethod.values()).stream()
            .filter(constants -> masterCode.masterCode().equals(constants.masterCode()))
            .findFirst().orElse(null);

        IO.println("---" + result.masterCode());

        var enumConstants = MasterCode.enumCode(LectureMethod.class, "LME003");
        IO.println("===" + enumConstants);

    }
}
