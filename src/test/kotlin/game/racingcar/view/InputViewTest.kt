package game.racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("게임 설정 값 입력 인터페이스 테스트")
internal class InputViewTest {

    @Test
    fun `정상 입력 테스트`() {
        // given
        val inputView = TestInputView()

        // when
        inputView.init()

        // then
        Assertions.assertThat(inputView.numberOfCar).isEqualTo(3)
        Assertions.assertThat(inputView.numberOfLap).isEqualTo(5)
    }
}

class TestInputView : InputView {
    override var numberOfCar: Int = 0

    override var numberOfLap: Int = 0

    override fun init() {
        numberOfCar = 3
        numberOfLap = 5
    }
}