/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abds040.fcitc_spark;


/**
 *
 * @author Daniel
 */
public class ReturnCodes {
    public static final String TC001u_UsernameInvalid      = "FCS0001u Username not valid.";
    public static final String TC001y_TokenInvalid         = "FCS0001y Token not valid.";
    public static final String TC001z_SOAPAuthError        = "FCS0001y Token SOAP Authentication Error.";
    
    
    public static final String TC100a_UserTestInitOK        = "FCS0100a UserTestInit OK.ä.ü.ö.á.";
    public static final String TC100z_UserTestInitError     = "FCS0100z UserTestInit failed. Unknown Error.";
    
    public static final String TC101a_RegisterOK            = "FCS0101a Registration OK.";
    public static final String TC101b_RegisterErrUsernameNU = "FCS0101b Registration failed. Username not unique.";
    public static final String TC101c_RegisterErrUsernameTS = "FCS0101c Registration failed. Username too short.";
    public static final String TC101d_RegisterErrUsernameTL = "FCS0101d Registration failed. Username too long.";
    public static final String TC101e_RegisterErrPasswordIV = "FCS0101e Registration failed. Password not valid.";
    public static final String TC101f_RegisterErrEmailNU    = "FCS0101f Registration failed. Email not unique.";
    public static final String TC101g_RegisterErrEmailIV    = "FCS0101g Registration failed. Email not valid.";
    public static final String TC101z_RegisterError         = "FCS0101z Registration failed. Unknown Error.";
    
    public static final String TC102a_ValidationOK            = "FCS0102a Validation OK.";
    public static final String TC102b_ValidationErrUsernameIV = "FCS0102b Validation failed. Username not valid.";
    public static final String TC102c_ValidationErrUsernameNF = "FCS0102c Validation failed. Username not valid."; // Same message to prevent DoS
    public static final String TC102d_ValidationErrStringIV   = "FCS0102d Validation failed. Validation String invalid.";
    public static final String TC102e_ValidationErrStringNM   = "FCS0102e Validation failed. Validation String does not match.";
    public static final String TC102f_ValidationErrAlreadyVal = "FCS0102f Validation failed. Already validated.";
    public static final String TC102z_ValidationError         = "FCS0102z Validation failed. Unknown Error.";
    
    public static final String TC111a_LoginOK                 = "FCS0111a Login OK.";
    public static final String TC111b_LoginErrPasswordNM      = "FCS0111b Login failed. Username or password wrong.";
    public static final String TC111y_UsernamePasswordInvalid = "FCS0111y Login failed. Username or password invalid.";
    public static final String TC111z_LoginError              = "FCS0111z Login failed. Unknown Error.";
    
    public static final String TC114a_LogoffOK                = "FCS0114a Logoff OK.";
    public static final String TC114y_LogoffFailed            = "FCS0114y Logoff failed.";
    public static final String TC114z_LogoffError             = "FCS0114z Logoff error.";
    
    public static final String TC120a_PasswordChangeOK        = "FCS0120a Password changed.";
    public static final String TC120b_PasswordChangeErrUser   = "FCS0120b Password not changed. user incorrect.";
    public static final String TC120c_PasswordChangeErrOld    = "FCS0120b Password not changed. Old password incorrect.";
    public static final String TC120d_PasswordChangeErrNew    = "FCS0120c Password not changed. New password invalid.";
    public static final String TC120y_PasswordChangeFailed    = "FCS0120y Password change failed.";
    public static final String TC120z_PasswordChangeError     = "FCS0120z Password change error.";
    
    public static final String TC200a_CatTestInitOK        = "FCS0200a CatTestInit OK.";
    public static final String TC200z_CatTestInitError     = "FCS0200z CatTestInit failed. Unknown Error.";
    
    public static final String TC201a_CatListOK               = "FCS0201a Category List OK.";
    public static final String TC201b_CatListErrorUserInvalid = "FCS0201b Category List failed. User invalid.";
    public static final String TC201c_CatListErrorUserUnknown = "FCS0201c Category List failed. User Unknown.";
    public static final String TC201z_CatListError            = "FCS0201z Category List failed. Unknown Error.";
    
    public static final String TC202a_CatShowOK                 = "FCS0202a Category Show OK.";
    public static final String TC202b_CatShowErrorUserInvalid   = "FCS0202b Category Show failed. User invalid.";
    public static final String TC202c_CatShowErrorUserUnknown   = "FCS0202c Category Show failed. User Unknown.";
    public static final String TC202d_CatShowErrorCatNotNumeric = "FCS0202d Category Show failed. Category not numeric.";
    public static final String TC202e_CatShowErrorCatInvalid    = "FCS0202e Category Show failed. Category invalid.";
    public static final String TC202f_CatShowErrorCatNotFound   = "FCS0202f Category Show failed. Category not found.";
    public static final String TC202z_CatShowError              = "FCS0202z Category Show failed. Unknown Error.";
    
    public static final String TC203a_CatAddOK                  = "FCS0203a Category AddOK.";
    public static final String TC203b_CatAddErrorUserInvalid    = "FCS0203bCategory Add failed. User invalid.";
    public static final String TC203c_CatAddErrorCatNameInvalid = "FCS0203cCategory Add failed. Category Name invalid.";
    public static final String TC203d_CatAddErrorCatDescInvalid = "FCS0203dCategory Add failed. Category Desc invalid.";
    public static final String TC203e_CatAddErrorCatExists      = "FCS0203eCategory Add failed. Category already exists.";
    public static final String TC203f_CatAddErrorRC             = "FCS0203fCategory Add failed. Bad RC.";
    public static final String TC203g_CatAddErrorInvalidKey     = "FCS0203gCategory Add failed. Invalid Key.";
    public static final String TC203z_CatAddError               = "FCS0203zCategory Add failed. Unknown Error.";
    
    public static final String TC204a_CatEditOK                 = "FCS0204a Category Edit OK.";
    public static final String TC204b_CatEditErrorUserInvalid   = "FCS0204b Category Edit failed. User invalid.";
    public static final String TC204c_CatEditErrorUserUnknown   = "FCS0204c Category Edit failed. User Unknown.";
    public static final String TC204d_CatEditErrorCatNotNumeric = "FCS0204d Category Edit failed. Category not numeric.";
    public static final String TC204e_CatEditErrorCatInvalid    = "FCS0204e Category Edit failed. Category invalid.";
    public static final String TC204f_CatEditErrorCatNotFound   = "FCS0204f Category Edit failed. Category not found.";
    public static final String TC204g_CatEditErrorCatNameInvalid= "FCS0204g Category Edit failed. Category name invalid.";
    public static final String TC204h_CatEditErrorCatDescInvalid= "FCS0204h Category Edit failed. Category description invalid.";
    public static final String TC204z_CatEditError              = "FCS0204z Category Edit failed. Unknown Error.";
    
    public static final String TC205a_CatDelOK                 = "FCS0205a Category Del OK.";
    public static final String TC205b_CatDelErrorUserInvalid   = "FCS0205b Category Del failed. User invalid.";
    public static final String TC205c_CatDelErrorUserUnknown   = "FCS0205c Category Del failed. User Unknown.";
    public static final String TC205d_CatDelErrorCatNotNumeric = "FCS0205d Category Del failed. Category not numeric.";
    public static final String TC205e_CatDelErrorCatInvalid    = "FCS0205e Category Del failed. Category invalid.";
    public static final String TC205f_CatDelErrorCatUnknown    = "FCS0205f Category Del failed. Category not found.";
    public static final String TC205g_CatDelErrorCatNotEmpty   = "FCS0205g Category Del failed. Category not empty.";
    public static final String TC205h_CatDelErrorCatNotDeleted = "FCS0205h Category Del failed. Category not deleted.";
    public static final String TC205z_CatDelError              = "FCS0205z Category Del failed. Unknown Error.";
    
    public static final String TC206a_CatSetOK                 = "FCS0206a Category Setting OK.";
    public static final String TC206b_CatSetErrorUserInvalid   = "FCS0206b Category Setting failed. User invalid.";
    public static final String TC206c_CatSetErrorUserUnknown   = "FCS0206c Category Setting failed. User Unknown.";
    public static final String TC206d_CatSetErrorCatNotNumeric = "FCS0206d Category Setting failed. Category not numeric.";
    public static final String TC206e_CatSetErrorCatInvalid    = "FCS0206e Category Setting failed. Category invalid.";
    public static final String TC206f_CatSetErrorCatNotFound   = "FCS0206f Category Setting failed. Category not found.";
    public static final String TC206xg_CatSetErrorCatNameInvalid= "FCS0206g Category Setting failed. Category name invalid.";
    public static final String TC206h_CatSetErrorSettingInvalid= "FCS0206h Category Setting failed. Setting invalid.";
    public static final String TC206ix_CatSetErrorValueInvalid  = "FCS0206i Category Setting failed. Value invalid.";
    public static final String TC206jx_CatSetErrorSettingUnknown= "FCS0206j Category Setting failed. Setting unknown.";
    public static final String TC206l_CatSetErrorMissingListLO = "FCS0206l Category Setting failed. ListLO missing.";
    public static final String TC206m_CatSetErrorMissingListHI = "FCS0206m Category Setting failed. ListHI missing.";
    public static final String TC206n_CatSetErrorMissingListSD = "FCS0206n Category Setting failed. ListSD missing.";
    public static final String TC206o_CatSetErrorMissingListSO = "FCS0206o Category Setting failed. ListSO missing.";
    public static final String TC206p_CatSetErrorInvalidListLO = "FCS0206p Category Setting failed. ListLO invalid.";
    public static final String TC206q_CatSetErrorInvalidListHI = "FCS0206q Category Setting failed. ListHI invalid.";
    public static final String TC206r_CatSetErrorInvalidListSD = "FCS0206r Category Setting failed. ListSD invalid.";
    public static final String TC206s_CatSetErrorInvalidListSO = "FCS0206s Category Setting failed. ListSO invalid.";
    public static final String TC206t_CatSetErrorMissingEmail  = "FCS0206t Category Setting failed. Email notification missing.";
    public static final String TC206u_CatSetErrorInvalidEmail  = "FCS0206u Category Setting failed. Email notification invalid.";
    public static final String TC206y_CatSetFailed             = "FCS0206y Category Setting failed.";
    public static final String TC206z_CatSetError              = "FCS0206z Category Setting failed. Unknown Error.";
    
    public static final String TC400a_CardTestInitOK        = "FCS0400a CardTestInit OK.";
    public static final String TC400z_CardTestInitError     = "FCS0400z CardTestInit failed. Unknown Error.";
    
    public static final String TC401a_CardListOK                   = "FCS0401a Card List OK.";
    public static final String TC401b_CardListErrorUserInvalid     = "FCS0401b Card List failed. User invalid.";
    public static final String TC401c_CardListErrorUserUnknown     = "FCS0401c Card List failed. User Unknown.";
    public static final String TC401d_CardListErrorCatNotNumeric   = "FCS0401d Card List failed. Category not numeric.";
    public static final String TC401e_CardListErrorCatInvalid      = "FCS0401e Card List failed. Category invalid.";
    public static final String TC401f_CardListErrorCatUnknown      = "FCS0401f Card List failed. Category not found.";
    public static final String TC401z_CardListError                = "FCS0401z Card List failed. Unknown Error.";
    
    public static final String TC402a_CardAddOK                   = "FCS0402a Card Add OK.";
    public static final String TC402b_CardAddErrorUserInvalid     = "FCS0402b Card Add failed. User invalid.";
    public static final String TC402c_CardAddErrorUserUnknown     = "FCS0402c Card Add failed. User Unknown.";
    public static final String TC402d_CardAddErrorCatNotNumeric   = "FCS0402d Card Add failed. Category not numeric.";
    public static final String TC402e_CardAddErrorCatInvalid      = "FCS0402e Card Add failed. Category invalid.";
    public static final String TC402f_CardAddErrorCatUnknown      = "FCS0402f Card Add failed. Category not found.";
    public static final String TC402j_CardAddErrorRC              = "FCS0402j Card Add failed. Card not inserted.";
    public static final String TC402k_CardAddErrorQuestionInvalid = "FCS0402k Card Add failed. Question invalid"
            + " ("+FlashCardConstants.DB_CARD_QUES_min+"-"+FlashCardConstants.DB_CARD_QUES_max+" characters.";
    public static final String TC402l_CardAddErrorAnswerInvalid   = "FCS0402l Card Add failed. Answer invalid"
            + " ("+FlashCardConstants.DB_CARD_ANSW_min+"-"+FlashCardConstants.DB_CARD_ANSW_max+" characters.";
    public static final String TC402m_CardAddErrorActiveInvalid   = "FCS0402m Card Add failed. Active value invalid (true/false).";
    public static final String TC402n_CardAddErrorToDoInvalid     = "FCS0402n Card Add failed. ToDo value invalid (true/false).";
    public static final String TC402o_CardAddErrorCommentsInvalid = "FCS0402o Card Add failed. Comments invalid"
            + " ("+FlashCardConstants.DB_CARD_COMM_min+"-"+FlashCardConstants.DB_CARD_COMM_max+" characters.";
    public static final String TC402z_CardAddError                = "FCS0402z Card Add failed. Unknown Error.";
    
    public static final String TC403a_CardShowOK                 = "FCS0403a Card Show OK.";
    public static final String TC403b_CardShowErrorUserInvalid   = "FCS0403b Card Show failed. User invalid.";
    public static final String TC403c_CardShowErrorUserUnknown   = "FCS0403c Card Show failed. User Unknown.";
    public static final String TC403d_CardShowErrorCatNotNumeric = "FCS0403d Card Show failed. Category not numeric.";
    public static final String TC403e_CardShowErrorCatInvalid    = "FCS0403e Card Show failed. Category invalid.";
    public static final String TC403f_CardShowErrorCatNotFound   = "FCS0403f Card Show failed. Category not found.";
    public static final String TC403g_CardShowErrorCardNotNumeric= "FCS0403g Card Show failed. Card not numeric.";
    public static final String TC403h_CardShowErrorCardInvalid   = "FCS0403h Card Show failed. Card invalid.";
    public static final String TC403i_CardShowErrorCardNotFound  = "FCS0403i Card Show failed. Card not found.";
    public static final String TC403z_CardShowError              = "FCS0403z Card Show failed. Unknown Error.";
    
    public static final String TC404a_CardDelOK                 = "FCS0404a Card Del OK.";
    public static final String TC404b_CardDelErrorUserInvalid   = "FCS0404b Card Del failed. User invalid.";
    public static final String TC404c_CardDelErrorUserUnknown   = "FCS0404c Card Del failed. User Unknown.";
    public static final String TC404d_CardDelErrorCatNotNumeric = "FCS0404d Card Del failed. Category not numeric.";
    public static final String TC404e_CardDelErrorCatInvalid    = "FCS0404e Card Del failed. Category invalid.";
    public static final String TC404f_CardDelErrorCatNotFound   = "FCS0404f Card Del failed. Category not found.";
    public static final String TC404g_CardDelErrorCardNotNumeric= "FCS0404g Card Del failed. Card not numeric.";
    public static final String TC404h_CardDelErrorCardInvalid   = "FCS0404h Card Del failed. Card invalid.";
    public static final String TC404i_CardDelErrorCardNotFound  = "FCS0404i Card Del failed. Card not found.";
    public static final String TC404z_CardDelError              = "FCS0404z Card Del failed. Unknown Error.";
    
    
    public static final String TC413a_CardSearchOK                   = "FCS0413a Card Search OK.";
    public static final String TC413b_CardSearchErrorUserInvalid     = "FCS0413b Card Search failed. User invalid.";
    public static final String TC413c_CardSearchErrorUserUnknown     = "FCS0413c Card Search failed. User Unknown.";
    public static final String TC413d_CardSearchErrorCatNotNumeric   = "FCS0413d Card Search failed. Category not numeric.";
    public static final String TC413e_CardSearchErrorCatInvalid      = "FCS0413e Card Search failed. Category invalid.";
    public static final String TC413f_CardSearchErrorCatUnknown      = "FCS0413f Card Search failed. Category not found.";
    public static final String TC413z_CardSearchError                 = "FCS0413z Card Search failed. Unknown Error.";
    
    public static final String TC421a_CardEditDataOK              = "FCS0421a Card EditData OK.";
    public static final String TC421b_CardEditDataErrorUserInvalid    = "FCS0421b Card EditData failed. User invalid.";
    public static final String TC421c_CardEditDataErrorUserUnknown    = "FCS0421c Card EditData failed. User Unknown.";
    public static final String TC421d_CardEditDataErrorCatNotNumeric  = "FCS0421d Card EditData failed. Category not numeric.";
    public static final String TC421e_CardEditDataErrorCatInvalid     = "FCS0421e Card EditData failed. Category invalid.";
    public static final String TC421f_CardEditDataErrorCatNotFound    = "FCS0421f Card EditData failed. Category not found.";
    public static final String TC421g_CardEditDataErrorCardNotNumeric = "FCS0421g Card EditData failed. Cardid not numeric.";
    public static final String TC421h_CardEditDataErrorCardInvalid    = "FCS0421h Card EditData failed. Cardid invalid.";
    public static final String TC421i_CardEditDataErrorCardNotFound   = "FCS0421i Card EditData failed. Card not found.";
    public static final String TC421k_CardEditDataErrorQuestionInvalid= "FCS0421k Card EditData failed. Question invalid"
            + " ("+FlashCardConstants.DB_CARD_QUES_min+"-"+FlashCardConstants.DB_CARD_QUES_max+" characters.";
    public static final String TC421l_CardEditDataErrorAnswerInvalid  = "FCS0421l Card EditData failed. Answer invalid"
            + " ("+FlashCardConstants.DB_CARD_ANSW_min+"-"+FlashCardConstants.DB_CARD_ANSW_max+" characters.";
    public static final String TC421p_CardEditDataErrorCardNotChanged = "FCS0421p Card EditData failed. Card not changed.";
    public static final String TC421z_CardEditDataError               = "FCS0421z Card EditData failed. Unknown Error.";
    
    public static final String TC420a_CardEditOK                  = "FCS0420a Card Edit OK.";
    public static final String TC420b_CardEditErrorUserInvalid    = "FCS0420b Card Edit failed. User invalid.";
    public static final String TC420c_CardEditErrorUserUnknown    = "FCS0420c Card Edit failed. User Unknown.";
    public static final String TC420d_CardEditErrorCatNotNumeric  = "FCS0420d Card Edit failed. Category not numeric.";
    public static final String TC420e_CardEditErrorCatInvalid     = "FCS0420e Card Edit failed. Category invalid.";
    public static final String TC420f_CardEditErrorCatNotFound    = "FCS0420f Card Edit failed. Category not found.";
    public static final String TC420g_CardEditErrorCardNotNumeric = "FCS0420g Card Edit failed. Cardid not numeric.";
    public static final String TC420h_CardEditErrorCardInvalid    = "FCS0420h Card Edit failed. Cardid invalid.";
    public static final String TC420i_CardEditErrorCardNotFound   = "FCS0420i Card Edit failed. Card not found.";
    public static final String TC420k_CardEditErrorQuestionInvalid= "FCS0420k Card Edit failed. Question invalid"
            + " ("+FlashCardConstants.DB_CARD_QUES_min+"-"+FlashCardConstants.DB_CARD_QUES_max+" characters.";
    public static final String TC420l_CardEditErrorAnswerInvalid  = "FCS0420l Card Edit failed. Answer invalid"
            + " ("+FlashCardConstants.DB_CARD_ANSW_min+"-"+FlashCardConstants.DB_CARD_ANSW_max+" characters.";
    public static final String TC420p_CardEditErrorCardNotChanged = "FCS0420p Card Edit failed. Card not changed.";
    public static final String TC420z_CardEditError               = "FCS0420z Card Edit failed. Unknown Error.";
    
    public static final String TC422a_CardEditMetaOK                  = "FCS0422a Card EditMeta OK.";
    public static final String TC422b_CardEditMetaErrorUserInvalid    = "FCS0422b Card EditMeta failed. User invalid.";
    public static final String TC422c_CardEditMetaErrorUserUnknown    = "FCS0422c Card EditMeta failed. User Unknown.";
    public static final String TC422d_CardEditMetaErrorCatNotNumeric  = "FCS0422d Card EditMeta failed. Category not numeric.";
    public static final String TC422e_CardEditMetaErrorCatInvalid     = "FCS0422e Card EditMeta failed. Category invalid.";
    public static final String TC422f_CardEditMetaErrorCatNotFound    = "FCS0422f Card EditMeta failed. Category not found.";
    public static final String TC422g_CardEditMetaErrorCardNotNumeric = "FCS0422g Card EditMeta failed. Cardid not numeric.";
    public static final String TC422h_CardEditMetaErrorCardInvalid    = "FCS0422h Card EditMeta failed. Cardid invalid.";
    public static final String TC422i_CardEditMetaErrorCardNotFound   = "FCS0422i Card EditMeta failed. Card not found.";
    public static final String TC422m_CardEditMetaErrorActiveInvalid  = "FCS0422m Card EditMeta failed. Active value invalid (true/false).";
    public static final String TC422n_CardEditMetaErrorToDoInvalid    = "FCS0422n Card EditMeta failed. ToDo value invalid (true/false).";
    public static final String TC422o_CardEditMetaErrorCommentsInvalid= "FCS0422o Card EditMeta failed. Comments invalid"
            + " ("+FlashCardConstants.DB_CARD_COMM_min+"-"+FlashCardConstants.DB_CARD_COMM_max+" characters.";
    public static final String TC422p_CardEditMetaErrorCardNotChanged = "FCS0422p Card EditMeta failed. Card not changed.";
    public static final String TC422r_CardEditMetaErrorLevelInvalid   = "FCS0422r Card EditMeta failed. Level invalid.";
    public static final String TC422s_CardEditMetaErrorPrioInvalid    = "FCS0422s Card EditMeta failed. Priority invalid (1-5 allowed).";
    public static final String TC422z_CardEditMetaError               = "FCS0422z Card EditMeta failed. Unknown Error.";
    
    public static final String TC423a_CardStudyUpdateOK                   = "FCS0423a Card StudyUpdate OK.";
    public static final String TC423b_CardStudyUpdateErrorUserInvalid     = "FCS0423b Card StudyUpdate failed. User invalid.";
    public static final String TC423c_CardStudyUpdateErrorUserUnknown     = "FCS0423c Card StudyUpdate failed. User Unknown.";
    public static final String TC423d_CardStudyUpdateErrorCatNotNumeric   = "FCS0423d Card StudyUpdate failed. Category not numeric.";
    public static final String TC423e_CardStudyUpdateErrorCatInvalid      = "FCS0423e Card StudyUpdate failed. Category invalid.";
    public static final String TC423f_CardStudyUpdateErrorCatUnknown      = "FCS0423f Card StudyUpdate failed. Category not found.";
    public static final String TC423g_CardStudyUpdateErrorCardIDNotNumeric= "FCS0423g Card StudyUpdate failed. CardID not numeric.";
    public static final String TC423h_CardStudyUpdateErrorCardIDInvalid   = "FCS0423h Card StudyUpdate failed. CardID invalid.";
    public static final String TC423i_CardStudyUpdateErrorCardIDNotFound  = "FCS0423i Card StudyUpdate failed. CardID not found.";
    public static final String TC423j_CardStudyUpdateErrorResultInvalid   = "FCS0423j Card StudyUpdate failed. Result invalid. 1(Good)-5(Bad).";
    public static final String TC423k_CardStudyUpdateErrorCardUpdateFailed= "FCS0423k Card StudyUpdate failed. Card update failed.";
    public static final String TC423z_CardStudyUpdateError                = "FCS0423z Card StudyUpdate failed. Unknown Error.";
    
    public static final String TC432a_CardDelayOK                         = "FCS0432a Card Delay OK.";
    public static final String TC432d_CardDelayErrorDelayNotNumeric       = "FCS0432d Card Delay failed. Category not numeric.";
    public static final String TC432e_CardDelayErrorDelayInvalid          = "FCS0432e Card Delay failed. Category invalid.";
    public static final String TC432k_CardDelayErrorCardUpdateFailed      = "FCS0432k Card Delay failed. Card update failed.";
    public static final String TC432z_CardDelayError                      = "FCS0432z Card Delay failed. Unknown error.";
    
    public static final String TC500a_ExerciseHelperPrepareListOK                = "FCS0500a Exercise HelperPrepareList OK.";
    public static final String TC500b_ExerciseHelperPrepareListErrorListNotFound = "FCS0500b Exercise HelperPrepareList failed. List not found.";
    public static final String TC500c_ExerciseHelperPrepareListErrorListNotValid = "FCS0500c Exercise HelperPrepareList failed. List not valid.";
    public static final String TC500z_ExerciseHelperPrepareListError = "FCS0500a Exercise HelperPrepareList failed. Unknown error.";
    
    public static final String TC501a_ExerciseGetlistOK                   = "FCS0501a Exercise Getlist OK.";
    public static final String TC501b_ExerciseGetlistErrorUserInvalid     = "FCS0501b Exercise Getlist failed. User invalid.";
    public static final String TC501c_ExerciseGetlistErrorUserUnknown     = "FCS0501c Exercise Getlist failed. User Unknown.";
    public static final String TC501d_ExerciseGetlistErrorCatNotNumeric   = "FCS0501d Exercise Getlist failed. Category not numeric.";
    public static final String TC501e_ExerciseGetlistErrorCatInvalid      = "FCS0501e Exercise Getlist failed. Category invalid.";
    public static final String TC501f_ExerciseGetlistErrorCatUnknown      = "FCS0501f Exercise Getlist failed. Category not found.";
    public static final String TC501j_ExerciseGetlistErrorListNotRetrieved= "FCS0501j Exercise Getlist failed. List could not be retrieved.";
    public static final String TC501z_ExerciseGetlistError                = "FCS0501z Exercise Getlist failed. Unknown Error.";
    
    public static final String TC510a_ExerciseGetNextCardIDOK                   = "FCS0510a Exercise GetNextCardID OK.";
    public static final String TC510b_ExerciseGetNextCardIDErrorUserInvalid     = "FCS0510b Exercise GetNextCardID failed. User invalid.";
    public static final String TC510c_ExerciseGetNextCardIDErrorUserUnknown     = "FCS0510c Exercise GetNextCardID failed. User Unknown.";
    public static final String TC510d_ExerciseGetNextCardIDErrorCatNotNumeric   = "FCS0510d Exercise GetNextCardID failed. Category not numeric.";
    public static final String TC510e_ExerciseGetNextCardIDErrorCatInvalid      = "FCS0510e Exercise GetNextCardID failed. Category invalid.";
    public static final String TC510f_ExerciseGetNextCardIDErrorCatUnknown      = "FCS0510f Exercise GetNextCardID failed. Category not found.";
    public static final String TC510j_ExerciseGetNextCardIDErrorListNotRetrieved= "FCS0510j Exercise GetNextCardID failed. List could not be retrieved.";
    public static final String TC510z_ExerciseGetNextCardIDError                = "FCS0510z Exercise GetNextCardID failed. Unknown Error.";

    public static final String TC511a_ExerciseDropCardOK                   = "FCS0511a Exercise DropCard OK.";
    public static final String TC511b_ExerciseDropCardErrorUserInvalid     = "FCS0511b Exercise DropCard failed. User invalid.";
    public static final String TC511c_ExerciseDropCardErrorUserUnknown     = "FCS0511c Exercise DropCard failed. User Unknown.";
    public static final String TC511d_ExerciseDropCardErrorCatNotNumeric   = "FCS0511d Exercise DropCard failed. Category not numeric.";
    public static final String TC511e_ExerciseDropCardErrorCatInvalid      = "FCS0511e Exercise DropCard failed. Category invalid.";
    public static final String TC511f_ExerciseDropCardErrorCatUnknown      = "FCS0511f Exercise DropCard failed. Category not found.";
    public static final String TC511g_ExerciseDropCardErrorCardIDNotNumeric= "FCS0511g Exercise DropCard failed. CardID not numeric.";
    public static final String TC511h_ExerciseDropCardErrorCardIDInvalid   = "FCS0511h Exercise DropCard failed. CardID invalid.";
    public static final String TC511j_ExerciseDropCardErrorListNotRetrieved= "FCS0511j Exercise DropCard failed. List could not be retrieved.";
    public static final String TC511k_ExerciseDropCardErrorCardNotFound    = "FCS0511k Exercise DropCard failed. Card not found.";
    public static final String TC511l_ExerciseDropCardErrorCardNotDropped  = "FCS0511l Exercise DropCard failed. Card not dropped.";
    public static final String TC511z_ExerciseDropCardError                = "FCS0511z Exercise DropCard failed. Unknown Error.";
    
    public static final String TC515a_ExerciseStudyCardOK                   = "FCS0515a Exercise StudyCard OK.";
    public static final String TC515b_ExerciseStudyCardErrorUserInvalid     = "FCS0515b Exercise StudyCard failed. User invalid.";
    public static final String TC515c_ExerciseStudyCardErrorUserUnknown     = "FCS0515c Exercise StudyCard failed. User Unknown.";
    public static final String TC515d_ExerciseStudyCardErrorCatNotNumeric   = "FCS0515d Exercise StudyCard failed. Category not numeric.";
    public static final String TC515e_ExerciseStudyCardErrorCatInvalid      = "FCS0515e Exercise StudyCard failed. Category invalid.";
    public static final String TC515f_ExerciseStudyCardErrorCatUnknown      = "FCS0515f Exercise StudyCard failed. Category not found.";
    public static final String TC515g_ExerciseStudyCardErrorCardIDNotNumeric= "FCS0515g Exercise StudyCard failed. CardID not numeric.";
    public static final String TC515h_ExerciseStudyCardErrorCardIDInvalid   = "FCS0515h Exercise StudyCard failed. CardID invalid.";
    public static final String TC515i_ExerciseStudyCardErrorResultInvalid   = "FCS0515i Exercise StudyCard failed. Result invalid. 1(Good)-5(Bad).";
    public static final String TC515j_ExerciseStudyCardErrorListNotRetrieved= "FCS0515j Exercise StudyCard failed. List could not be retrieved.";
    public static final String TC515k_ExerciseStudyCardErrorCardNotFound    = "FCS0515k Exercise StudyCard failed. Card not found.";
    public static final String TC515l_ExerciseStudyCardErrorCardNotDropped  = "FCS0515l Exercise StudyCard failed. Card not dropped.";
    public static final String TC515m_ExerciseStudyCardErrorCardNotUpdated  = "FCS0515m Exercise StudyCard failed. Card not updated.";
    public static final String TC515z_ExerciseStudyCardError                = "FCS0515z Exercise StudyCard failed. Unknown Error.";
    
    
    public static final String TC601a_UploadBasicCSVOK                   = "FCS0601a Upload BasicCSV OK.";
    public static final String TC601b_UploadBasicCSVErrorUserInvalid     = "FCS0601b Upload BasicCSV failed. User invalid.";
    public static final String TC601c_UploadBasicCSVErrorUserUnknown     = "FCS0601c Upload BasicCSV failed. User Unknown.";
    public static final String TC601d_UploadBasicCSVErrorCatNotNumeric   = "FCS0601d Upload BasicCSV failed. Category not numeric.";
    public static final String TC601e_UploadBasicCSVErrorCatInvalid      = "FCS0601e Upload BasicCSV failed. Category invalid.";
    public static final String TC601f_UploadBasicCSVErrorCatUnknown      = "FCS0601f Upload BasicCSV failed. Category not found.";
    public static final String TC601i_UploadBasicCSVErrorSeparatorInvalid= "FCS0601i Upload BasicCSV failed. Separator invalid.";
    public static final String TC601j_UploadBasicCSVErrorListInvalid     = "FCS0601j Upload BasicCSV failed. List invalid.";
    public static final String TC601k_UploadBasicCSVErrorListParseFailed = "FCS0601k Upload BasicCSV failed. List parsing failed.";
    public static final String TC601l_UploadBasicCSVErrorListTooBigFailed= "FCS0601l Upload BasicCSV failed. List too big.";
    public static final String TC601m_UploadBasicCSVErrorListNotUploaded = "FCS0601m Upload BasicCSV failed. List not uploaded.";
    public static final String TC601z_UploadBasicCSVError                = "FCS0601z Upload BasicCSV failed. Unknown Error.";
    
    public static final String TC701z_DownloadBasicCSVError                = "FCS0701z Download BasicCSV failed. Unknown Error.";
    
    public static final String TC712z_DownloadNormalXMLError               = "FCS0712z Download NormalXML failed. Unknown Error.";
    public static final String TC713z_DownloadExtendedXMLError             = "FCS0713z Download ExtendedXML failed. Unknown Error.";
    
    
    public static final String TC901a_StatisticsOK                   = "FCS0901a Statistics OK.";
    public static final String TC901b_StatisticsErrorInvalid         = "FCS0901b Statistics failed. User invalid.";
    public static final String TC901c_StatisticsErrorUserUnknown     = "FCS0901c Statistics failed. User Unknown.";
    public static final String TC901d_StatisticsErrorCatNotNumeric   = "FCS0901d Statistics failed. Category not numeric.";
    public static final String TC901e_StatisticsErrorCatInvalid      = "FCS0901e Statistics failed. Category invalid.";
    public static final String TC901f_StatisticsErrorCatUnknown      = "FCS0901f Statistics failed. Category not found.";
    public static final String TC901z_StatisticsError                = "FCS0901z Statistics failed. Unknown Error.";
    
    public static final String TC902a_StatisticsDailyActivityOK                   = "FCS0902a Statistics DailyActivity OK.";
    public static final String TC902b_StatisticsDailyActivityErrorInvalid         = "FCS0902b Statistics DailyActivity failed. User invalid.";
    public static final String TC902c_StatisticsDailyActivityErrorUserUnknown     = "FCS0902c Statistics DailyActivity failed. User Unknown.";
    public static final String TC902d_StatisticsDailyActivityErrorCatNotNumeric   = "FCS0902d Statistics DailyActivity failed. Category not numeric.";
    public static final String TC902e_StatisticsDailyActivityErrorCatInvalid      = "FCS0902e Statistics DailyActivity failed. Category invalid.";
    public static final String TC902f_StatisticsDailyActivityErrorCatUnknown      = "FCS0902f Statistics DailyActivity failed. Category not found.";
    public static final String TC902z_StatisticsDailyActivityError                = "FCS0902z Statistics DailyActivity failed. Unknown Error.";
    
    public static final String TC903a_CatStatisticsOK                   = "FCS0903a Cat Statistics OK.";
    public static final String TC903b_CatStatisticsErrorUserInvalid     = "FCS0903b Cat Statistics failed. User invalid.";
    public static final String TC903c_CatStatisticsErrorUserUnknown     = "FCS0903c Cat Statistics failed. User Unknown.";
    public static final String TC903d_CatStatisticsErrorCatNotNumeric   = "FCS0903d Cat Statistics failed. Category not numeric.";
    public static final String TC903e_CatStatisticsErrorCatInvalid      = "FCS0903e Cat Statistics failed. Category invalid.";
    public static final String TC903f_CatStatisticsErrorCatUnknown      = "FCS0903f Cat Statistics failed. Category not found.";
    public static final String TC903z_CatStatisticsError                = "FCS0903z Cat Statistics failed. Unknown Error.";
    
    public static final String TC904a_CardStatisticsOK                   = "FCS0904a Card Statistics OK.";
    public static final String TC904b_CardStatisticsErrorUserInvalid     = "FCS0904b Card Statistics failed. User invalid.";
    public static final String TC904c_CardStatisticsErrorUserUnknown     = "FCS0904c Card Statistics failed. User Unknown.";
    public static final String TC904d_CardStatisticsErrorCatNotNumeric   = "FCS0904d Card Statistics failed. Category not numeric.";
    public static final String TC904e_CardStatisticsErrorCatInvalid      = "FCS0904e Card Statistics failed. Category invalid.";
    public static final String TC904f_CardStatisticsErrorCatUnknown      = "FCS0904f Card Statistics failed. Category not found.";
    public static final String TC904g_CardStatisticsErrorCardNotNumeric  = "FCS0904g Card Statistics failed. Card not numeric.";
    public static final String TC904h_CardStatisticsErrorCardInvalid     = "FCS0904h Card Statistics failed. Card invalid.";
    public static final String TC904i_CardStatisticsErrorCardUnknown     = "FCS0904i Card Statistics failed. Card not found.";
    public static final String TC904z_CardStatisticsError                = "FCS0904z Card Statistics failed. Unknown Error.";
    
    //public static final String N0001_LoginFailed        = "FCS0111A-1E Logon failed.";
    //public static final String N0002_FatalError         = "FCS00-2E Fatal Error.";
    //public static final String M0001_LoginOK            = "FCS0001I Logon OK.";
 
    
    public static void main(String[] args) {
       
        
    }
}
