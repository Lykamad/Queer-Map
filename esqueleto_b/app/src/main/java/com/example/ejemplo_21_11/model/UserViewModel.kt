package com.example.ejemplo_21_11.model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.ejemplo_21_11.database.ProfileEntity
import com.example.ejemplo_21_11.database.UserDatabase
import com.example.ejemplo_21_11.database.UserEntity
import com.example.ejemplo_21_11.database.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application){

    //Mi profile

    private val _profileName = MutableLiveData<String>("")
    val profileName: LiveData<String> = _profileName

    fun onProfileNameChange(newData: String){
        _profileName.value = newData
    }

    private val _profilePic = MutableLiveData<String>("")
    val profilePic: LiveData<String> = _profilePic

    fun onProfilePicChange(newData: String){
        _profilePic.value = newData
    }

    private val _profilePronouns = MutableLiveData<String>("")
    val profilePronouns: LiveData<String> = _profilePronouns

    fun onProfilePronounsChange(newData: String) {
        _profilePronouns.value = newData
    }

    private val _profileDescription = MutableLiveData<String>("")
    val profileDescription: LiveData<String> = _profileDescription

    fun onProfileDescriptionChange(newData: String) {
        _profileDescription.value = newData
    }

    private val _profileSexuality = MutableLiveData<String>("")
    val profileSexuality: LiveData<String> = _profileSexuality

    fun onProfileSexualityChange(newData: String) {
        _profileSexuality.value = newData
    }

    private val _profileLocation = MutableLiveData<String>("")
    val profileLocation: LiveData<String> = _profileLocation

    fun onProfileLocationChange(newData: String) {
        _profileLocation.value = newData
    }


    //Fin my profile

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
    val readAllDataProfile: LiveData<List<ProfileEntity>>
    private val repository: UserRepository

    //inicializamos la instancia de la base de datos
    init {
        val userDB= UserDatabase.getInstance(application).userDao()
        repository = UserRepository(userDB)
        readAllData = repository.readAllData
        readAllDataProfile = repository.readAllDataProfile
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

    //Actualizar perfil
    fun addProfile(profile: ProfileEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.addProfile(profile)
        }
    }


    fun updateProfile(profile: ProfileEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.updateProfile(userItem = profile)
        }
    }

    fun deleteUserProfile(profile: ProfileEntity){
        viewModelScope.launch(Dispatchers.IO) {     // como en el DAO se definen con suspend al llamarlos se hace con launch
            repository.deleteProfile(userItem = profile)
        }
    }
    //Fin actualizar perfil

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