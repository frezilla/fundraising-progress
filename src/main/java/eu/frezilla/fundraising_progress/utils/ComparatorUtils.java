package eu.frezilla.fundraising_progress.utils;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ComparatorUtils {
    
    public static int compareProcess(int...compareResult) {
        if (compareResult.length == 0) return 0;
        
        int compareValue = 0;
        for (int value : compareResult) {
            if (Objects.equals(value, 0)) return 0;
            compareValue = value;
        }
        return compareValue;
    }
    
}
