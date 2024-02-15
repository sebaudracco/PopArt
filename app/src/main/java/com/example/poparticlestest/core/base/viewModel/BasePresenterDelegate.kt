
import com.google.gson.Gson


abstract class BasePresenterDelegate(private val bindingDelegate: BaseBindingDelegate) {

    fun showDefaultBackendError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
        bindingDelegate.hideTimeOutErrorPostValue()
    }

    fun hideDefaultBackendError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
        bindingDelegate.hideTimeOutErrorPostValue()
    }

    fun showGenericError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
        bindingDelegate.hideTimeOutErrorPostValue()
        bindingDelegate.hideDefaultBeErrorPostValue()
    }

    fun hideGenericError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
        bindingDelegate.hideTimeOutErrorPostValue()
        bindingDelegate.hideDefaultBeErrorPostValue()
    }

    fun showInternetConnectionError() {
        bindingDelegate.showErrorInternetConnectionPostValue()
    }

    fun hideInternetConnectionError() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.hideErrorInternetConnectionPostValue()
        bindingDelegate.hideGenericErrorPostValue()
        bindingDelegate.hideTimeOutErrorPostValue()
        bindingDelegate.hideDefaultBeErrorPostValue()
    }

    fun showProgressView() {
        bindingDelegate.showProgressViewPostValue()
    }

    fun hideProgressView() {
        bindingDelegate.hideProgressViewPostValue()
    }

    fun showSuccessLogout() {
        bindingDelegate.hideProgressViewPostValue()
        bindingDelegate.showSuccessLogoutPostValue()
    }

    /*fun showDefaultApiError(error: ErrorModel) {
        bindingDelegate.hideProgressViewPostValue()
        if (error.errorStatus == ErrorModel.ErrorStatus.CUSTOM_ERROR) {
            val exceptionModel = Gson().fromJson(error.message, ExceptionModel::class.java)
            bindingDelegate.showDefaultBeErrorPostValue(exceptionModel)
            return
        }

        when (error.errorStatus) {
            ErrorModel.ErrorStatus.NO_CONNECTION -> bindingDelegate.showErrorInternetConnectionPostValue()
            ErrorModel.ErrorStatus.UNAUTHORIZED -> bindingDelegate.showLogoutPostValue()
            ErrorModel.ErrorStatus.TIMEOUT -> bindingDelegate.showTimeOutErrorPostValue()
            else -> bindingDelegate.showGenericErrorPostValue(ExceptionModel())
        }
    }*/


}