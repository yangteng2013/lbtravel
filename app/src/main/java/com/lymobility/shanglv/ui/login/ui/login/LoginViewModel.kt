package com.lymobility.shanglv.ui.login.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.lymobility.shanglv.R
import com.lymobility.shanglv.base.BaseViewModel
import com.lymobility.shanglv.base.launch
import com.lymobility.shanglv.data.bean.ArticleData
import com.lymobility.shanglv.data.bean.Employee
import com.lymobility.shanglv.data.bean.LoadState
import com.lymobility.shanglv.data.remote.Repository
import com.lymobility.shanglv.data.remote.Response
import com.lymobility.shanglv.ui.login.data.LoginRepository
import com.lymobility.shanglv.ui.login.data.Result


class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
    val data = MutableLiveData<Response<Employee>>()
    fun login2(username: String, password: String) = launch({
        loadState.value = LoadState.Loading()
        data.value = Repository.login(username,password)
        loadState.value = LoadState.Success()
    },{
        loadState.value = LoadState.Fail()
    })

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('1')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}