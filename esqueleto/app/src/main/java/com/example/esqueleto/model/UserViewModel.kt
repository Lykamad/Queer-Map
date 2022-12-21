package com.example.esqueleto.model

import android.app.Application
import androidx.lifecycle.*
import com.example.esqueleto.database.UserDatabase
import com.example.esqueleto.database.UserEntity
import com.example.esqueleto.database.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application){

    private val _userName = MutableLiveData<String>("")
    val userName: LiveData<String> = _userName

    fun onUserNameChange(newUserName: String){
        _userName.value = newUserName
    }

    private val _userPhoto = MutableLiveData<String>("")
    val userPhoto: LiveData<String> = _userPhoto

    fun onUserPhotoChange(newUserPhoto: String){
        _userPhoto.value = newUserPhoto
    }

    private val _userPhone = MutableLiveData<String>("")
    val userPhone: LiveData<String> = _userPhone

    fun onUserPhoneChange(newUserPhone: String){
        _userPhone.value = newUserPhone
    }

    private val _userEmail = MutableLiveData<String>("")
    val userEmail: LiveData<String> = _userEmail

    fun onUserEmailChange(newUserEmail: String){
        _userEmail.value = newUserEmail
    }

    private val _userCity = MutableLiveData<String>("")
    val userCity: LiveData<String> = _userCity

    fun onUserCityChange(newUserCity: String){
        _userCity.value = newUserCity
    }

    private val _europe = MutableLiveData<Boolean>(false)
    val europe: LiveData<Boolean> = _europe

    fun onEuropeChange(newEurope: Boolean){
        _europe.value = newEurope
    }

    //Room Repository Functions
    val readAllData: LiveData<List<UserEntity>>
    private val repository: UserRepository

    //inicializamos la instancia de la base de datos
    init {
        val userDB= UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDB)
        readAllData = repository.readAllData
    }

    fun addListUsers(users: List<UserEntity>){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.addListUser(users)
        }
    }

    fun addUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.addUser(user)
        }
    }

    fun updateUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.updateUser(userItem = user)
        }
    }

    fun deleteUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.deleteUser(userItem = user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.deleteAllUsers()
        }
    }
}

class UserViewModelFactory(private val application: Application): ViewModelProvider.Factory { //sobreescribir el ViewModel antiguo, hacerlo porque si xd, no examen
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}