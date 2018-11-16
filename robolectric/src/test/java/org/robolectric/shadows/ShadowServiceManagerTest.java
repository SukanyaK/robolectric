package org.robolectric.shadows;

import static com.google.common.truth.Truth.assertThat;

import android.content.Context;
import android.os.ServiceManager;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Tests for {@link ShadowServiceManager}. */
@RunWith(AndroidJUnit4.class)
public final class ShadowServiceManagerTest {

  @Test
  public void getService_available_shouldReturnNonNull() throws Exception {
    assertThat(ServiceManager.getService(Context.INPUT_METHOD_SERVICE)).isNotNull();
  }

  @Test
  public void getService_unavailableService_shouldReturnNull() throws Exception {
    ShadowServiceManager.setServiceAvailability(Context.INPUT_METHOD_SERVICE, false);
    assertThat(ServiceManager.getService(Context.INPUT_METHOD_SERVICE)).isNull();
  }
}
