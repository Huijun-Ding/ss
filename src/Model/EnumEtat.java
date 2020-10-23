package Model;

public enum EnumEtat {  // enums sur les différents états de tâche
    EN_COURS,   // En cours d'affectation de tâche
    ANNULEE,    // l'annulation de tâche
    ACCEPTEE,   // une fois tous les intervenants sont trouvés, cette tâche passe à l'état ACCEPTEE
    PAYEE,      // Dès que la tâche est ACCEPTEE, le client peut payer la plateforme, parès la paiement, l'état modifie à PAYEE
    FINALISEE_INTER,  // Dès que l'intervenant fini la tâche, il annonce la finalisation
    VALIDEE_CLIENT    // Dès que le client a validé le travail de l'intervenant, état modifie à VALIDEE_CLIENT, et la plateforme peut payer l'intervenant
}
