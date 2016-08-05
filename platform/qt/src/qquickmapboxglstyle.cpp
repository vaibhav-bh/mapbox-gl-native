#include <QQuickMapboxGLStyle>
#include <QQuickMapboxGLStyleProperty>

QQuickMapboxGLStyle::QQuickMapboxGLStyle(QQuickItem *parent)
    : QQuickItem(parent)
{
}

void QQuickMapboxGLStyle::itemChange(QQuickItem::ItemChange change, const QQuickItem::ItemChangeData &value)
{
    QQuickItem::itemChange(change, value);

    switch (change) {
    case QQuickItem::ItemChildAddedChange:
        if (QQuickMapboxGLStyleProperty *property = qobject_cast<QQuickMapboxGLStyleProperty *>(value.item)) {
            connect(property, SIGNAL(updated(QVariantMap)), this, SIGNAL(propertyUpdated(QVariantMap)));
            connect(this, SIGNAL(styleChanged(QString)), property, SLOT(checkUpdated()));
        }
        break;
    case QQuickItem::ItemChildRemovedChange:
        if (QQuickMapboxGLStyleProperty *property = qobject_cast<QQuickMapboxGLStyleProperty *>(value.item)) {
            disconnect(property, SIGNAL(updated(QVariantMap)), this, SIGNAL(propertyUpdated(QVariantMap)));
            disconnect(this, SIGNAL(styleChanged(QString)), property, SLOT(checkUpdated()));
        }
        break;
    default:
        break;
    }
}

void QQuickMapboxGLStyle::setStyle(const QString &style)
{
    if (style == m_style) {
        return;
    }

    m_style = style;
    emit styleChanged(style);
}

QString QQuickMapboxGLStyle::style() const
{
    return m_style;
}

void QQuickMapboxGLStyle::setStyleClass(const QString &styleClass)
{
    if (styleClass == m_class) {
        return;
    }

    m_class = styleClass;
    emit classChanged(styleClass);
}

QString QQuickMapboxGLStyle::styleClass() const
{
    return m_class;
}
