package com.basalamah.muhammadsyarif.myfootballmatch.presenters

import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.view.EventNextView
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DetailPresenterTest {
    @Test
    fun unitDetail() {
        val testAct = mock(DetailPresenter::class.java)
        testAct.getDetail("576549")
        verify(testAct).getDetail("576549")
    }
}