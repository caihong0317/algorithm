package com.caihong.jianzhioffer;

public class Question19 {
    public static void main(String[] args) {
        String regex1 = "a.a";
        String regex2 = "ab*ac*a";
        String regex3 = "a.*a";
        String target = "aaaa";
    }

    // todo 考虑的越多，情况越复杂，没法写了
    public static boolean match(String regex, String target) {
        if (regex == null || target == null) {
            return false;
        }
        char[] tar = target.toCharArray();
        char[] reg = regex.toCharArray();
        return doMatch(reg, 0, tar, 0);
    }

    private static boolean doMatch(char[] reg, int regIndex, char[] tar, int tarIndex) {

        boolean isMatcher = true;
        if (reg[regIndex + 1] != '*') {
            if (reg[regIndex] != '.') {
                //1.匹配a
                isMatcher = reg[regIndex] == tar[tarIndex];
            }
            //2.匹配.时直接进下一轮
        } else {
            //3.匹配a*
            if (reg[regIndex] != '.') {
                // 出现0次
                if (reg[regIndex] != tar[tarIndex]) {
                    isMatcher = doMatch(reg, regIndex + 2, tar, tarIndex);
                } else {
                    // 1次以上
                    while (reg[regIndex] == tar[tarIndex] && tarIndex < tar.length) {
                        tarIndex++;
                    }
                    if (tarIndex < tar.length && regIndex + 2 < reg.length) {
                        isMatcher = doMatch(reg, regIndex + 2, tar, tarIndex);
                    } else if ((tarIndex == tar.length && regIndex + 2 < reg.length)
                        || (tarIndex < tar.length && regIndex + 1 == reg.length)) {
                        isMatcher = false;
                    }
                }
            } else {
                //4.匹配.*，这种情况太复杂(.*之后可能还出现*)，暂不考虑
                if (regIndex == reg.length - 2) {
                    // .*在末尾，则通吃
                    return true;
                } else {
//                    isMatcher=doMatch(reg,regIndex+2,tar,tarIndex+?);
                }
            }
        }
        if (isMatcher) {
            return doMatch(reg, regIndex + 1, tar, tarIndex + 1);
        } else {
            //不匹配
            return isMatcher;
        }
    }
}
