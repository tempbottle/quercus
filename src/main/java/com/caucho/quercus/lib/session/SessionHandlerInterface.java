package com.caucho.quercus.lib.session;

import com.caucho.quercus.env.StringValue;

/**
 * PHP >= 5.4.0<br/>
 * <b>SessionHandlerInterface</b> is an interface which defines
 * a prototype for creating a custom session handler.
 * In order to pass a custom session handler to
 * session_set_save_handler() using its OOP invocation,
 * the class must implement this interface.
 *
 * @link http://php.net/manual/en/class.sessionhandlerinterface.php
 */
public interface SessionHandlerInterface {

    /**
     * PHP >= 5.4.0<br/>
     * Close the session
     *
     * @return bool <p>
     * The return value (usually TRUE on success, FALSE on failure).
     * Note this value is returned internally to PHP for processing.
     * </p>
     * @link http://php.net/manual/en/sessionhandlerinterface.close.php
     */
    public boolean close();

    /**
     * PHP >= 5.4.0<br/>
     * Destroy a session
     *
     * @param session_id The session ID being destroyed.
     * @return bool <p>
     * The return value (usually TRUE on success, FALSE on failure).
     * Note this value is returned internally to PHP for processing.
     * </p>
     * @link http://php.net/manual/en/sessionhandlerinterface.destroy.php
     */
    public boolean destroy(String session_id);

    /**
     * PHP >= 5.4.0<br/>
     * Cleanup old sessions
     *
     * @param maxlifetime <p>
     *                    Sessions that have not updated for
     *                    the last maxlifetime seconds will be removed.
     *                    </p>
     * @return bool <p>
     * The return value (usually TRUE on success, FALSE on failure).
     * Note this value is returned internally to PHP for processing.
     * </p>
     * @link http://php.net/manual/en/sessionhandlerinterface.gc.php
     */
    public boolean gc(long maxlifetime);

    /**
     * PHP >= 5.4.0<br/>
     * Initialize session
     *
     * @param save_path  The path where to store/retrieve the session.
     * @param session_id The session id.
     * @return bool <p>
     * The return value (usually TRUE on success, FALSE on failure).
     * Note this value is returned internally to PHP for processing.
     * </p>
     * @link http://php.net/manual/en/sessionhandlerinterface.open.php
     */
    public boolean open(String save_path, String session_id);


    /**
     * PHP >= 5.4.0<br/>
     * Read session data
     *
     * @param session_id The session id to read data for.
     * @return string <p>
     * Returns an encoded string of the read data.
     * If nothing was read, it must return an empty string.
     * Note this value is returned internally to PHP for processing.
     * </p>
     * @link http://php.net/manual/en/sessionhandlerinterface.read.php
     */
    public StringValue read(String session_id);

    /**
     * PHP >= 5.4.0<br/>
     * Write session data
     *
     * @param session_id   The session id.
     * @param session_data <p>
     *                     The encoded session data. This data is the
     *                     result of the PHP internally encoding
     *                     the $_SESSION superglobal to a serialized
     *                     string and passing it as this parameter.
     *                     Please note sessions use an alternative serialization method.
     *                     </p>
     * @return bool <p>
     * The return value (usually TRUE on success, FALSE on failure).
     * Note this value is returned internally to PHP for processing.
     * </p>
     * @link http://php.net/manual/en/sessionhandlerinterface.write.php
     */
    public boolean write(String session_id, String session_data);
}