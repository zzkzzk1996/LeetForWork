package Day02;

/**
 * @program: LeetForWork
 * @description: 393. UTF-8 Validation
 * @author: Zekun Zhang
 * @create: 2019-09-02 13:20
 */

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if ((data[i] & 128) == 0) {
                continue;
            } else {
                if (data[i] >= 248) {
                    return false;
                }
                else if (data[i] >= 240) {
                    if (n < i + 3) {
                        return false;
                    }
                    if ((data[i + 1] & 128) != 128) {
                        return false;
                    }
                    if ((data[i + 2] & 128) != 128) {
                        return false;
                    }
                    if ((data[i + 3] & 128) != 128) {
                        return false;
                    }
                    i += 3;
                }
                else if (data[i] >= 224) {
                    if (n < i + 2) {
                        return false;
                    }
                    if ((data[i + 1] & 128) != 128) {
                        return false;
                    }
                    if ((data[i + 2] & 128) != 128) {
                        return false;
                    }
                    i += 2;
                }
                else if (data[i] >= 192) {
                    if (n < i + 1) {
                        return false;
                    }
                    if ((data[i + 1] & 128) != 128) {
                        return false;
                    }
                    i++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
