package com.example.esqueleto.model

import android.app.Application
import androidx.lifecycle.*
import com.example.esqueleto.database.LocationsEntity
import com.example.esqueleto.database.UserDatabase
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
    val readAllData: LiveData<List<LocationsEntity>>
    private val repository: UserRepository

    //inicializamos la instancia de la base de datos
    init {
        val userDB= UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDB)
        readAllData = repository.readAllData
    }

    fun addListLocation(users: List<LocationsEntity>){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.addListLocation(users)
        }
    }

    fun addLocation(user: LocationsEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.addLocation(user)
        }
    }

    fun updateUser(location: LocationsEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.updateLocation(locationItem = location)
        }
    }

    fun deleteUser(location: LocationsEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.deleteLocation(locationItem = location)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.deleteAllLocations()
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