package com.dsm_delivery.feature.signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dsm_delivery.R
import com.dsm_delivery.domain.entity.SignInEntity
import com.dsm_delivery.navigation.AppNavigationItem
import com.dsm_delivery.util.makeToast

@Composable
fun SignInScreen(navController: NavController){
    val context = LocalContext.current
    val signInViewModel: SignInViewModel = hiltViewModel()
    LaunchedEffect(Unit){
        signInViewModel.eventFlow.collect{
            when(it){
                is SignInViewModel.Event.Success -> {
                    navController.navigate(AppNavigationItem.Main.route) { popUpTo(0) }
                }
                is SignInViewModel.Event.BadRequest -> {
                    context.getString(R.string.BadRequest)
                }
                is SignInViewModel.Event.NotFound -> {
                    context.getString(R.string.NotFound)
                }
                is SignInViewModel.Event.Unauthorized -> {
                    context.getString(R.string.Unauthorized)
                }
            }
        }
    }
    SignIn(
        onBackClick = { navController.popBackStack() },
        onSignInClick = {signInViewModel.signIn(it)}
    )
}

@Composable
fun SignIn(
    onBackClick: () -> Unit,
    onSignInClick: (SignInEntity) -> Unit,
){


}