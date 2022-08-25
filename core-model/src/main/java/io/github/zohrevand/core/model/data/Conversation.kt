package io.github.zohrevand.core.model.data

import io.github.zohrevand.core.model.data.ConversationStatus.Started

data class Conversation(
    val peerJid: String,
    val status: ConversationStatus,
    val draftMessage: String? = null,
    val lastMessage: Message? = null,
    val unreadMessagesCount: Int = 0,
    val chatState: ChatState = ChatState.Idle,
    val isChatOpen: Boolean = false
) {
    companion object {
        fun createNewConversation(peerJid: String) =
            Conversation(
                peerJid = peerJid,
                status = Started,
                isChatOpen = true
            )
    }
}

val Conversation.peerLocalPart: String
    get() = peerJid.substringBefore("@")

val Conversation.firstLetter: String
    get() = peerJid.take(1).uppercase()

val Conversation.subtitle: String?
    get() = when {
        draftMessage != null -> {
            "Draft: ${draftMessage.trim()}"
        }
        lastMessage != null && lastMessage.isMine -> {
            "You: ${lastMessage.body.trim()}"
        }
        else -> lastMessage?.body?.trim()
    }
