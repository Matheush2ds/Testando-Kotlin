/*
Programa Teste para brincar com os amigos, ao passar o mouse sobre o não
ele irá correr do curso do mouse, sendo possível apenas apertar no Label "SIM"
 */
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JOptionPane
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.awt.Font
import java.awt.Point
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class MexerMouse : JFrame() {
    private lateinit var yesLabel: JLabel
    private lateinit var noLabel: JLabel
    private lateinit var messageLabel: JLabel
    private lateinit var point: Point
    private var flag = true

    init {
        title = "Programa para teste"

        messageLabel = JLabel("Você é ") //sua mensagem
        messageLabel.font = Font("Arial", Font.BOLD, 20)
        yesLabel = JLabel("Sim")
        yesLabel.font = Font("Arial", Font.BOLD, 35)
        noLabel = JLabel("Não")
        noLabel.font = Font("Arial", Font.BOLD, 35)
        point = noLabel.location

        yesLabel.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                JOptionPane.showMessageDialog(null, "Sua pegadinha") //Sua mensagem para o Label "sim"
            }
        })

        noLabel.addMouseListener(object : MouseAdapter() {
            override fun mouseEntered(e: MouseEvent?) {
                if (flag) {
                    point = noLabel.location
                    noLabel.location = Point(point.x + 100, point.y)
                }
            }

            override fun mouseExited(e: MouseEvent?) {
                if (flag) {
                    noLabel.location = point
                }
            }

            override fun mousePressed(e: MouseEvent?) {
                flag = false
            }

            override fun mouseReleased(e: MouseEvent?) {
                flag = true
            }
        })

        val container = JPanel()
        container.layout = GridBagLayout()
        val gbc = GridBagConstraints()
        gbc.insets = Insets(5, 5, 5, 5)
        gbc.gridx = 0
        gbc.gridy = 0
        container.add(messageLabel, gbc)
        gbc.gridx = 0
        gbc.gridy = 1
        container.add(yesLabel, gbc)
        gbc.gridx = 1
        container.add(noLabel, gbc)

        add(container)
        pack()
        isVisible = true
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
}

fun main() {
    val MexerMouse = MexerMouse()
}