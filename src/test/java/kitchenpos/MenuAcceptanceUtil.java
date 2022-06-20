package kitchenpos;

import kitchenpos.dto.MenuGroupResponse;
import kitchenpos.dto.MenuResponse;
import kitchenpos.dto.ProductResponse;

import java.math.BigDecimal;

import static kitchenpos.MenuAcceptanceTest.메뉴_등록됨;
import static kitchenpos.MenuGroupAcceptanceTest.메뉴_그룹_등록됨;
import static kitchenpos.ProductAcceptanceTest.상품_등록됨;

public final class MenuAcceptanceUtil {

    private MenuAcceptanceUtil() {
    }

    public static MenuResponse 신메뉴_강정치킨_가져오기() {
        ProductResponse 강정치킨 = 상품_등록됨("강정치킨", BigDecimal.valueOf(15_000L));
        MenuGroupResponse 신메뉴 = 메뉴_그룹_등록됨("신메뉴");
        return 메뉴_등록됨("강정치킨", BigDecimal.valueOf(15_000L), 신메뉴.getId(), 강정치킨);
    }
}