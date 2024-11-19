// 카테고리 클릭 시 공원 목록을 로드하는 함수
function loadParks(category) {
    $.get("/parks", { category: category }, function(data) {
        updateParkList(data.parks);
    });
}

// 공원 리스트를 화면에 동적으로 표시하는 함수
function updateParkList(parks) {
    var parkListContainer = $(".scroll_list_ul");  // 공원 목록을 담을 DOM 요소
    parkListContainer.empty();  // 기존 목록을 비운다.

    if (parks.length > 0) {
        parks.forEach(function(park) {
            var parkHtml = `
                <li>
                    <ul class="scroll_list">
                        <li class="category">
                            <span>${park.category}</span> <!-- 카테고리 -->
                        </li>
                        <li class="content">
                            <h4>${park.p_na}</h4> <!-- 공원 이름 -->
                            <p class="text">${park.p_ce_na}</p> <!-- 관리기관명 -->
                            <p class="address">${park.p_ad}</p> <!-- 공원 주소 -->
                        </li>
                    </ul>
                </li>
            `;
            parkListContainer.append(parkHtml);  // 공원 목록에 항목 추가
        });
    } else {
        parkListContainer.append("<p>검색된 공원이 없습니다.</p>");  // 결과가 없을 때
    }
}